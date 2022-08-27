package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsConfig;
import top.dragon.mapper.SmsConfigMapper;
import top.dragon.service.SmsConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
@Service
public class SmsConfigServiceImpl extends ServiceImpl<SmsConfigMapper, SmsConfig> implements SmsConfigService {



    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ResultEntity select(Integer type) {
        if (type == null) {
            return ResultEntity.succeed(this.list());
        }else{
            return ResultEntity.succeed(this.list(new QueryWrapper<SmsConfig>().eq("config_type", type)));
        }
    }

    @Override
    public ResultEntity change(Integer configId, String configValue) {
        return ResultEntity.succeed(this.update(new UpdateWrapper<SmsConfig>().
                eq("config_id", configId).set("config_value", configValue)));
    }

    @Override
    public ResultEntity selectInfo(String type, String classify, String group, String name) {
        SmsConfig one = this.getOne(new QueryWrapper<SmsConfig>().
                eq("config_type", type).eq("config_classify", classify).eq("config_group", group).eq("config_name", name));
        redisTemplate.opsForValue().set("test1", one);


        return ResultEntity.succeed(one);
    }
}
