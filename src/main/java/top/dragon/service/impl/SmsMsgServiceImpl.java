package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsMsg;
import top.dragon.mapper.SmsMsgMapper;
import top.dragon.service.SmsMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 信息内容 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsMsgServiceImpl extends ServiceImpl<SmsMsgMapper, SmsMsg> implements SmsMsgService {

    @Override
    public ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId) {
        return ResultEntity.succeed(this.page(new Page<>(page, size),new QueryWrapper<SmsMsg>().
                eq("msg_uid",userId).eq("msg_type",type)));
    }
}
