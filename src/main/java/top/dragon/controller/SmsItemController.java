package top.dragon.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsItem;
import top.dragon.service.SmsItemService;

/**
 * <p>
 * 项目 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/item")
public class SmsItemController {

    @Resource
    private SmsItemService itemService;

    @RequestMapping("/select")
    public ResultEntity select(String name) {
        return itemService.select(name);
    }

    //申请项目
    @RequestMapping("/apply")
    public ResultEntity apply(@RequestBody SmsItem item) {
        return itemService.apply(item);
    }

}

