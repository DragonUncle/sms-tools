package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsItem;
import top.dragon.mapper.SmsItemMapper;
import top.dragon.service.SmsItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsItemServiceImpl extends ServiceImpl<SmsItemMapper, SmsItem> implements SmsItemService {

    @Override
    public ResultEntity select(String name) {
        if (StringUtils.isBlank(name)) {
            return ResultEntity.error("名称不能为空");
        }
        List<SmsItem> list = this.list(new QueryWrapper<SmsItem>().eq("item_status", 1).
                        eq("item_is_del", false).and(wrapper -> wrapper.like("item_name", name).
                        or().like("item_id", name))
        );
        return ResultEntity.succeed(list);
    }

    @Override
    public ResultEntity apply(SmsItem item) {
        return null;
    }
}
