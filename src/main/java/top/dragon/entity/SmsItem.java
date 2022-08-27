package top.dragon.entity;

import java.math.BigDecimal;
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
 * 项目
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_item")
@ApiModel(value="SmsItem对象", description="项目")
public class SmsItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目Id")
    @TableId(value = "item_id", type = IdType.AUTO)
    private Integer itemId;

    @ApiModelProperty(value = "用户Id")
    private Integer itemUid;

    @ApiModelProperty(value = "名称")
    private String itemName;

    @ApiModelProperty(value = "内容")
    private String itemValue;

    @ApiModelProperty(value = "价格")
    private BigDecimal itemPrice;

    @ApiModelProperty(value = "是否删除")
    private Integer itemIsDel;

    @ApiModelProperty(value = "状态")
    private Integer itemStatus;

    @ApiModelProperty(value = "类型")
    private Integer itemType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime itemCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime itemUpdateTime;


}
