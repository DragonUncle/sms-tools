package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsExclusive;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 专属 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsExclusiveService extends IService<SmsExclusive> {

    ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId);

    ResultEntity add(Integer projectId, Integer userId);

    ResultEntity delete(Integer projectId, Integer userId);
}
