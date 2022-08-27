package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 项目 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsItemService extends IService<SmsItem> {

    ResultEntity select(String name);

    ResultEntity apply(SmsItem item);
}
