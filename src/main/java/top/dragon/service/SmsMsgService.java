package top.dragon.service;

import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsMsg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 信息内容 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsMsgService extends IService<SmsMsg> {

    ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId);
}
