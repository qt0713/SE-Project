
package vip.xiaonuo.dev.modular.file.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;

/**
 * 文件实体
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:27
 **/
@Getter
@Setter
@TableName("DEV_FILE")
public class DevFile extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 存储引擎 */
    @Schema(description = "存储引擎")
    private String engine;

    /** 存储桶 */
    @Schema(description = "存储桶")
    private String bucket;

    /** 文件名称 */
    @Schema(description = "文件名称")
    private String name;

    /** 文件后缀 */
    @Schema(description = "文件后缀")
    private String suffix;

    /** 文件大小kb */
    @Schema(description = "文件大小kb")
    private String sizeKb;

    /** 文件大小（格式化后） */
    @Schema(description = "文件大小（格式化后）")
    private String sizeInfo;

    /** 文件的对象名（唯一名称） */
    @Schema(description = "文件的对象名（唯一名称）")
    private String objName;

    /** 文件存储路径 */
    @Schema(description = "文件存储路径")
    private String storagePath;

    /** 文件下载路径 */
    @Schema(description = "文件下载路径")
    private String downloadPath;

    /** 图片缩略图 */
    @Schema(description = "图片缩略图")
    private String thumbnail;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;
}
