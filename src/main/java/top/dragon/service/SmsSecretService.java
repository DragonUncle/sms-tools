package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsSecret;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 卡密 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsSecretService extends IService<SmsSecret> {

    ResultEntity create(Integer number, Integer money, Integer userId);

    ResultEntity select(Integer page, Integer size,  Integer type,Integer userId);

    ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId);

    ResultEntity delete(Integer id, Integer userId);

    ResultEntity recycle(Integer id, Integer userId);

    ResultEntity use(String secretCard, Integer userId);
}
