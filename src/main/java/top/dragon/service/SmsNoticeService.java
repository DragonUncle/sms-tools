package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
public interface SmsNoticeService extends IService<SmsNotice> {

    ResultEntity selectAll( Integer type);

    ResultEntity add(Integer noticeType, String noticeName, String noticeValue, Integer userId);

    ResultEntity delete(Integer noticeId, Integer userId);
}
