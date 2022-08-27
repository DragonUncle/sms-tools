package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 拉黑手机号
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_defriend")
@ApiModel(value="SmsDefriend对象", description="拉黑手机号")
public class SmsDefriend implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户Id")
    @TableId(value = "defriend_uid", type = IdType.NONE)
    private Integer defriendUid;

    @ApiModelProperty(value = "手机号")
    private String defriendPhone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "拉黑时间")
    private LocalDateTime defriendCreateTime;


}
