
package vip.xiaonuo.dev.modular.dev;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.dev.api.DevApi;
import vip.xiaonuo.dev.modular.dict.entity.DevDict;
import vip.xiaonuo.dev.modular.dict.enums.DevDictCategoryEnum;
import vip.xiaonuo.dev.modular.dict.service.DevDictService;
import vip.xiaonuo.dev.modular.email.service.DevEmailService;
import vip.xiaonuo.dev.modular.file.service.DevFileService;
import vip.xiaonuo.dev.modular.job.service.DevJobService;
import vip.xiaonuo.dev.modular.message.service.DevMessageService;
import vip.xiaonuo.dev.modular.sms.service.DevSmsService;

/**
 * 开发工具模块综合API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/9/26 14:30
 **/
@Service
public class DevApiProvider implements DevApi {

    @Resource
    private DevDictService devDictService;

    @Resource
    private DevJobService devJobService;

    @Resource
    private DevFileService devFileService;

    @Resource
    private DevSmsService devSmsService;

    @Resource
    private DevEmailService devEmailService;

    @Resource
    private DevMessageService devMessageService;

    @Override
    public JSONObject getDevOpCount() {
        Long sysDictCount = devDictService.count(new LambdaQueryWrapper<DevDict>().eq(DevDict::getCategory,
                DevDictCategoryEnum.FRM.getValue()));
        Long bizDictCount = devDictService.count(new LambdaQueryWrapper<DevDict>().eq(DevDict::getCategory,
                DevDictCategoryEnum.BIZ.getValue()));
        Long jobCount = 0L;
//        Long jobCount = devJobService.count(new LambdaQueryWrapper<DevJob>().eq(DevJob::getJobStatus,
//                DevJobStatusEnum.RUNNING.getValue()));
        JSONObject json = new JSONObject();
        json.set("sysDictCount", sysDictCount);
        json.set("bizDictCount", bizDictCount);
        json.set("jobCount", jobCount);
        return json;
    }

    @Override
    public JSONObject getToolDataCount() {
        JSONObject json = new JSONObject();
        json.set("fileCount", devFileService.count());
        json.set("smsCount", devSmsService.count());
        json.set("emailCount", devEmailService.count());
        json.set("messageCount", devMessageService.count());
        return json;
    }
}
