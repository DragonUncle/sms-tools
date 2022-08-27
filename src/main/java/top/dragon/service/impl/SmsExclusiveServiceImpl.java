package top.dragon.service.impl;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsExclusive;
import top.dragon.mapper.SmsExclusiveMapper;
import top.dragon.service.SmsExclusiveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 专属 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsExclusiveServiceImpl extends ServiceImpl<SmsExclusiveMapper, SmsExclusive> implements SmsExclusiveService {

    @Override
    public ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity add(Integer projectId, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity delete(Integer projectId, Integer userId) {
        return null;
    }
}
