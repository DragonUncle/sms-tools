package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 剔除项目
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_exclude")
@ApiModel(value="SmsExclude对象", description="剔除项目")
public class SmsExclude implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "剔除项目信息id")
    @TableId(value = "exclude_id", type = IdType.AUTO)
    private Integer excludeId;

    @ApiModelProperty(value = "剔除项目的用户Id")
    private Integer excludeUid;

    @ApiModelProperty(value = "剔除的项目id")
    private Integer excludePid;

    @ApiModelProperty(value = "剔除的时间")
    private LocalDateTime excludeCreateTime;

    @ApiModelProperty(value = "剔除的状态")
    private Integer excludeStatus;

    @ApiModelProperty(value = "剔除是否被删除")
    private Boolean excludeIsDel;


}
