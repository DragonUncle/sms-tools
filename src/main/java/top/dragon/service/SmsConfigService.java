package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
public interface SmsConfigService extends IService<SmsConfig> {

    ResultEntity select(Integer type);

    ResultEntity change(Integer configId, String configValue);

    ResultEntity selectInfo(String type, String classify, String group, String name);
}
