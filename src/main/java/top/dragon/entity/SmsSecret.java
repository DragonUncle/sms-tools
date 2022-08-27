package top.dragon.entity;

import java.math.BigDecimal;
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
 * 卡密
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_secret")
@ApiModel(value="SmsSecret对象", description="卡密")
public class SmsSecret implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卡密Id")
    @TableId(value = "secret_id", type = IdType.AUTO)
    private Integer secretId;

    @ApiModelProperty(value = "卡密sId")
    private Integer secretSid;

    @ApiModelProperty(value = "卡密uId")
    private Integer secretUid;

    @ApiModelProperty(value = "卡密创建时间")
    private LocalDateTime secretCreateTime;

    @ApiModelProperty(value = "卡密使用时间")
    private LocalDateTime secretUseTime;

    @ApiModelProperty(value = "卡密状态")
    private Integer secretStatus;

    @ApiModelProperty(value = "卡密是否被删除")
    private Boolean secretIsDel;

    @ApiModelProperty(value = "卡密金额")
    private BigDecimal secretMoney;

    @ApiModelProperty(value = "卡密编号")
    private String secretCode;


}
