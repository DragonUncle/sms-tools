package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsDefriend;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 拉黑手机号 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsDefriendService extends IService<SmsDefriend> {

    ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId);

    ResultEntity add(Integer phone, Integer userId);

    ResultEntity delete(Integer phone, Integer userId);
}
