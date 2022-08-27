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
 * 账单
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_bill")
@ApiModel(value="SmsBill对象", description="账单")
public class SmsBill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账单Id")
    @TableId(value = "bill_id", type = IdType.NONE)
    private Long billId;

    @ApiModelProperty(value = "用户Id")
    private Integer billUid;

    @ApiModelProperty(value = "类型 0支出 1收入 2转换 3兑现")
    private Integer billType;

    @ApiModelProperty(value = "方式 1支付包 2微信 3银行卡 4兑换 5U币 ")
    private Integer billWay;

    @ApiModelProperty(value = "账单金额")
    private BigDecimal billMoney;

    @ApiModelProperty(value = "用户持有金额")
    private BigDecimal billBalance;

    @ApiModelProperty(value = "账单创建时间")
    private LocalDateTime billCreateTime;

    @ApiModelProperty(value = "账单是否被删除")
    private Integer billIsDel;


}
