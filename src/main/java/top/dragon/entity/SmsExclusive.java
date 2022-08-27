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
 * 专属
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_exclusive")
@ApiModel(value="SmsExclusive对象", description="专属")
public class SmsExclusive implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专属Id")
    @TableId(value = "exclusive_id", type = IdType.NONE)
    private Integer exclusiveId;

    @ApiModelProperty(value = "项目Id")
    private Integer exclusiveItemId;

    @ApiModelProperty(value = "专属代码")
    private String exclusiveCoding;

    @ApiModelProperty(value = "专属用户")
    private Integer exclusiveUid;

    @ApiModelProperty(value = "专属价格")
    private BigDecimal exclusivePrice;

    @ApiModelProperty(value = "专属创建时间")
    private LocalDateTime exclusiveCreateTime;

    @ApiModelProperty(value = "专属分类 0我的专属 1公开专属")
    private Integer exclusiveType;

    @ApiModelProperty(value = "是否删除")
    private Integer exclusiveIsDel;

    @ApiModelProperty(value = "状态")
    private Integer exclusiveStatus;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime exclusiveOverdue;


}
