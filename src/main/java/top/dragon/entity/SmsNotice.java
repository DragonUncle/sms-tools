package top.dragon.entity;

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
 * 
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_notice")
@ApiModel(value="SmsNotice对象", description="")
public class SmsNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告Id")
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    @ApiModelProperty(value = "公告名字")
    private String noticeName;

    @ApiModelProperty(value = "公告内容")
    private String noticeValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "公告时间")
    private LocalDateTime noticeCreateTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean noticeIsDel;

    @ApiModelProperty(value = "状态")
    private Integer noticeStatus;

    private Integer noticeType;


}
