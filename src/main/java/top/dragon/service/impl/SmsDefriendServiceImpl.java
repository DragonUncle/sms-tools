package top.dragon.service.impl;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsDefriend;
import top.dragon.mapper.SmsDefriendMapper;
import top.dragon.service.SmsDefriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 拉黑手机号 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsDefriendServiceImpl extends ServiceImpl<SmsDefriendMapper, SmsDefriend> implements SmsDefriendService {

    @Override
    public ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity add(Integer phone, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity delete(Integer phone, Integer userId) {
        return null;
    }
}
