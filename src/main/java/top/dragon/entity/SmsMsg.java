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
 * 信息内容
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_msg")
@ApiModel(value="SmsMsg对象", description="信息内容")
public class SmsMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "信息Id")
    @TableId(value = "msg_id", type = IdType.NONE)
    private Long msgId;

    @ApiModelProperty(value = "手机号")
    private String msgPhone;

    @ApiModelProperty(value = "类型 0接受 1发送")
    private String msgType;

    @ApiModelProperty(value = "项目Id")
    private Integer msgProjectId;

    @ApiModelProperty(value = "项目分支")
    private String msgBranch;

    @ApiModelProperty(value = "用户Id")
    private Integer msgUid;

    @ApiModelProperty(value = "商家Id")
    private Integer msgSid;

    @ApiModelProperty(value = "消息内容")
    private String msgValue;

    @ApiModelProperty(value = "消息代码")
    private String msgCode;

    @ApiModelProperty(value = "消息创建时间")
    private LocalDateTime msgCreateTime;

    @ApiModelProperty(value = "消息价格")
    private BigDecimal msgPrice;

    @ApiModelProperty(value = "用户价格")
    private BigDecimal msgUserPrice;

    @ApiModelProperty(value = "消息返回时间")
    private LocalDateTime msgFinishTime;

    @ApiModelProperty(value = "消息是否删除")
    private Integer msgIsDel;

    @ApiModelProperty(value = "详细状态")
    private Integer msgStatus;


}
