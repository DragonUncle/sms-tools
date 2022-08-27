package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsExclude;
import top.dragon.mapper.SmsExcludeMapper;
import top.dragon.service.SmsExcludeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 剔除项目 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsExcludeServiceImpl extends ServiceImpl<SmsExcludeMapper, SmsExclude> implements SmsExcludeService {

    @Override
    public ResultEntity selectAll(Integer page, Integer size, Integer type, Integer userId) {
        QueryWrapper<SmsExclude> smsExcludeQueryWrapper = new QueryWrapper<SmsExclude>().eq("exclude_is_del",false);
        if (userId != 0) smsExcludeQueryWrapper.eq("exclude_sid",userId);
        return ResultEntity.succeed(this.page(new Page<>(page,size),smsExcludeQueryWrapper));
    }

    @Override
    public ResultEntity add(Integer projectId, Integer userId) {
        SmsExclude smsExclude = new SmsExclude();
        smsExclude.setExcludeUid(userId);
        smsExclude.setExcludePid(projectId);
        smsExclude.setExcludeIsDel(false);
        smsExclude.setExcludeStatus(0);
        smsExclude.setExcludeCreateTime(LocalDateTime.now());
        return ResultEntity.isValid(this.save(smsExclude));
    }

    @Override
    public ResultEntity delete(Integer projectId, Integer userId) {
        return ResultEntity.isValid(this.remove(new QueryWrapper<SmsExclude>().eq("exclude_pid",projectId).
                eq("exclude_uid",userId)));
    }
}
