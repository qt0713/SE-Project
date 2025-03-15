
package vip.xiaonuo.common.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import vip.xiaonuo.common.exception.CommonException;

import java.io.File;
import java.io.InputStream;

/**
 * 根据ip地址定位工具类，离线方式
 * 参考地址：https://gitee.com/lionsoul/ip2region/tree/master/binding/java
 *
 * @author xuyuxiang
 * @date 2020/3/16 11:25
 */
@Slf4j
public class CommonIpAddressUtil {

    private static final String LOCAL_REMOTE_HOST = "0:0:0:0:0:0:0:1";

    private static final String IP2REGION_DB_PATH = "/ip2region.xdb";

    private static final Searcher searcher = initSearcher();

    /**
     * 私有构造函数防止实例化
     */
    private CommonIpAddressUtil() {
    }

    /**
     * 初始化Searcher实例
     *
     * @return Searcher
     */
    private static Searcher initSearcher() {
        try {
            final File dbFile = FileUtil.file(FileUtil.getTmpDir() + FileUtil.FILE_SEPARATOR + IP2REGION_DB_PATH);
            if (!FileUtil.exist(dbFile)) {
                try (InputStream inputStream = CommonIpAddressUtil.class.getResourceAsStream(IP2REGION_DB_PATH)) {
                    FileUtil.writeFromStream(inputStream, dbFile);
                }
            }
            // 1、从 dbPath 加载整个 xdb 到内存。
            final byte[] cBuff = Searcher.loadContentFromFile(dbFile.getPath());
            // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
            return Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            log.error(">>> CommonIpAddressUtil初始化异常：", e);
            throw new CommonException("CommonIpAddressUtil初始化异常");
        }
    }

    /**
     * 获取客户端ip
     *
     * @author xuyuxiang
     * @date 2020/3/19 9:32
     */
    public static String getIp(HttpServletRequest request) {
        if (ObjectUtil.isEmpty(request)) {
            return Ipv4Util.LOCAL_IP;
        }
        try {
            String remoteHost = JakartaServletUtil.getClientIP(request);
            return LOCAL_REMOTE_HOST.equals(remoteHost) ? Ipv4Util.LOCAL_IP : remoteHost;
        } catch (Exception e) {
            log.error(">>> 获取客户端ip异常：", e);
            return Ipv4Util.LOCAL_IP;
        }
    }

    /**
     * 根据IP地址离线获取城市
     *
     * @author xuyuxiang
     * @date 2022/4/27 23:14
     */
    public static String getCityInfo(String ip) {
        try {
            // 3、执行查询
            String region = searcher.search(ip.trim());
            return region.replace("0|", "").replace("|0", "");
        } catch (Exception e) {
            return "未知";
        }
    }
}
