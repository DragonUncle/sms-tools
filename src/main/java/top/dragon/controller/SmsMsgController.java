package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsMsgService;

/**
 * <p>
 * 信息内容 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/msg")
public class SmsMsgController {

    @Resource
    private SmsMsgService msgService;

    //查询所有信息
    @RequestMapping("/selectAll")
    public ResultEntity selectAll(Integer page, Integer size, Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return msgService.selectAll(page, size, type,userId);
    }



}

