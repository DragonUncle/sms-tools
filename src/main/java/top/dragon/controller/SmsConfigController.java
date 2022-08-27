package top.dragon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsConfigService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/config")
public class SmsConfigController {

    @Autowired
    private SmsConfigService configService;

    //查询配置
    @RequestMapping("/select")
    public ResultEntity select(Integer type) {
        return configService.select(type);
    }

    //查询配置
    @RequestMapping("/selectInfo")
    public ResultEntity selectInfo(String type,String classify,String group,String name) {
        return configService.selectInfo(type,classify,group,name);
    }
    //修改配置
    @RequestMapping("/change")
    public ResultEntity change(Integer configId, String configValue) {
        return configService.change(configId,configValue);
    }

}

