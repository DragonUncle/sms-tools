package top.dragon.service.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.dragon.config.RedisConfiguration;
import top.dragon.job.PhoneInfo;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsMobileService;

import java.util.List;

@Service
public class SmsMobileServiceImpl implements SmsMobileService {


    @Autowired
    private RedisConfiguration redisConfiguration;

    @Resource
    @Qualifier(value = "systemRedisTemplate")
    private RedisTemplate<String,Object> systemRedisTemplate;
    @Resource
    @Qualifier(value = "phoneRedisTemplate")
    private RedisTemplate<String,Object> phoneRedisTemplate;
    @Resource
    @Qualifier(value = "userRedisTemplate")
    private RedisTemplate<String,Object> userRedisTemplate;
    @Resource
    @Qualifier(value = "messageRedisTemplate")
    private RedisTemplate<String,Object> messageRedisTemplate;



    @Override
    public ResultEntity itemPhoneNumber(Integer itemId, Integer userId) {


        return null;
    }

    @Override
    public ResultEntity release(String phone, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity black(String phone, Integer userId) {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.setPhone(phone);
        phoneInfo.setUid(userId);
        phoneInfo.setStatus(0);
        phoneInfo.setLevel(0);
        //判断手机号是否是虚拟号码



        if(systemRedisTemplate.opsForHash().hasKey("system:phone",phone)){
            return new ResultEntity(0,"该号码是虚拟号码，不能拉黑");
        }

        //phoneRedisTemplate.opsForValue().set(phone,);

        return null;
    }

    @Override
    public ResultEntity addPhoneNumber(String phoneNumber, Integer userId) {









        return null;
    }

    @Override
    public ResultEntity addPhoneNumbers(List<String> phoneNumbers, Integer userId) {







        return null;
    }
}
