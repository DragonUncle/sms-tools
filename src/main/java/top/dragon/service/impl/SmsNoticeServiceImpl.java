package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsNotice;
import top.dragon.mapper.SmsNoticeMapper;
import top.dragon.service.SmsNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
@Service
public class SmsNoticeServiceImpl extends ServiceImpl<SmsNoticeMapper, SmsNotice> implements SmsNoticeService {

    @Override
    public ResultEntity selectAll( Integer type) {
        QueryWrapper<SmsNotice> noticeQueryWrapper = new QueryWrapper<SmsNotice>().eq("notice_type", type).
                eq("notice_is_del", false).orderByDesc("notice_create_time");
        return ResultEntity.succeed(this.getOne(noticeQueryWrapper));
    }

    @Override
    public ResultEntity add(Integer noticeType, String noticeName, String noticeValue, Integer userId) {

        SmsNotice smsNotice = new SmsNotice();
        smsNotice.setNoticeType(noticeType);
        smsNotice.setNoticeName(noticeName);
        smsNotice.setNoticeValue(noticeValue);
        smsNotice.setNoticeIsDel(false);
        smsNotice.setNoticeCreateTime(LocalDateTime.now());
        return ResultEntity.succeed(this.save(smsNotice));
    }

    @Override
    public ResultEntity delete(Integer noticeId, Integer userId) {
        return ResultEntity.isValid(this.update(new UpdateWrapper<SmsNotice>().
                eq("notice_id", noticeId).set("notice_is_del", true)));
    }
}
