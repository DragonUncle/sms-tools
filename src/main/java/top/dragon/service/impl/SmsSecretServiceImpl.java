package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsSecret;
import top.dragon.entity.SmsUser;
import top.dragon.mapper.SmsSecretMapper;
import top.dragon.service.SmsSecretService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dragon.service.SmsUserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * 卡密 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsSecretServiceImpl extends ServiceImpl<SmsSecretMapper, SmsSecret> implements SmsSecretService {


    @Resource
    private SmsUserService userService;

    @Override
    @Transactional
    public ResultEntity create(Integer number, Integer money, Integer userId) {

        SmsUser smsUser = userService.getById(userId);
        if(smsUser == null){
            return ResultEntity.error("用户不存在");
        }
        BigDecimal secretMoney =BigDecimal.valueOf(Long.valueOf(money) * number);
        BigDecimal userMoney = smsUser.getUserMoney();
        if(userMoney.compareTo(secretMoney) < 0){
            return ResultEntity.error("余额不足");
        }
        smsUser.setUserMoney(userMoney.subtract(secretMoney));
        userService.updateById(smsUser);
        for (int i = 0; i < number; i++) {
            SmsSecret smsSecret = new SmsSecret();
            smsSecret.setSecretMoney(BigDecimal.valueOf(Long.valueOf(money)));
            smsSecret.setSecretStatus(0);
            smsSecret.setSecretCode(UUID.randomUUID().toString());
            smsSecret.setSecretCreateTime(LocalDateTime.now());
            smsSecret.setSecretSid(userId);
            smsSecret.setSecretIsDel(false);
            this.save(smsSecret);
        }
        return ResultEntity.succeed();
    }

    @Override
    public ResultEntity select(Integer page, Integer size, Integer type, Integer userId) {

        QueryWrapper<SmsSecret> queryWrapper = new QueryWrapper<SmsSecret>()
                .eq("secret_is_del", false).eq("secret_status", type);
        if (userId != 0) queryWrapper.eq("secret_sid", userId);
        return ResultEntity.succeed(this.page(new Page<>(page, size), queryWrapper));
    }

    @Override
    public ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity delete(Integer id, Integer userId) {

        UpdateWrapper<SmsSecret> smsSecretQueryWrapper = new UpdateWrapper<SmsSecret>()
                .eq("secret_id",id).set("secret_is_del",false);
        if (userId != 0) smsSecretQueryWrapper.eq("secret_sid",userId);
        return ResultEntity.isValid(this.update(smsSecretQueryWrapper));
    }

    @Override
    public ResultEntity recycle(Integer id, Integer userId) {
        return null;
    }

    @Override
    public ResultEntity use(String secretCard, Integer userId) {


        String[] split = secretCard.split("\\.");
        if(split.length != 3){
            return ResultEntity.error("卡密格式错误");
        }
        Integer sId = Integer.parseInt(split[0]);
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(split[1]));
        String code = split[2];
        SmsSecret secret = this.getOne(new QueryWrapper<SmsSecret>()
                .eq("secret_sid", sId)
                .eq("secret_code", code)
                .eq("secret_is_del", false));
        if(secret == null) return ResultEntity.error("卡密不存在");

        if(secret.getSecretStatus() == 1) return ResultEntity.error("卡密已使用");

        return ResultEntity.isValid(this.update(new UpdateWrapper<SmsSecret>()
                .eq("secret_sid",sId).eq("secret_code",code).eq("secret_is_del",false)
                .set("secret_status",1).set("secret_use_time",LocalDateTime.now()).set("secret_uid",userId)),"使用成功","使用失败");

    }
}
