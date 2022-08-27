package top.dragon.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户列表
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_user")
@ApiModel(value="SmsUser对象", description="用户列表")
public class SmsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户Id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户类型 0普通用户1卡商2开发者")
    private Integer userType;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户超级密码")
    private String userSuperPassword;

    @ApiModelProperty(value = "用户余额")
    private BigDecimal userMoney;

    @ApiModelProperty(value = "用户等级")
    private Integer userLevel;

    @ApiModelProperty(value = "用户经验")
    private BigDecimal userExp;

    @ApiModelProperty(value = "用户联系方式")
    private String userContact;

    @ApiModelProperty(value = "用户设备")
    private String userDevice;

    @ApiModelProperty(value = "用户是否删除")
    private Boolean userIsDel;

    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "用户创建时间")
    private LocalDateTime userCreateTime;

    @ApiModelProperty(value = "用户父id")
    private Integer userPid;

    @TableField(exist = false)
    @ApiModelProperty(value = "密钥")
    private String userKey;

}
