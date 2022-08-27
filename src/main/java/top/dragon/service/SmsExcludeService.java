package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsExclude;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 剔除项目 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsExcludeService extends IService<SmsExclude> {

    ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId);


    ResultEntity add(Integer projectId, Integer userId);

    ResultEntity delete(Integer projectId, Integer userId);
}
