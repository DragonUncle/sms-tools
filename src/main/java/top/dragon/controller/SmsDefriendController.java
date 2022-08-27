package top.dragon.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsDefriendService;

/**
 * <p>
 * 拉黑手机号 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/defriend")
public class SmsDefriendController {

    @Autowired
    private SmsDefriendService defriendService;

    //查询所有拉黑手机号
    @RequestMapping("/selectAll")
    public ResultEntity selectAll(Integer page, Integer size, Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return defriendService.selectAll(page, size, type,userId);
    }
    //添加拉黑手机号
    @RequestMapping("/add")
    public ResultEntity add(Integer phone, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return defriendService.add(phone,userId);
    }
    //删除拉黑手机号
    @RequestMapping("/delete")
    public ResultEntity delete(Integer phone, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return defriendService.delete(phone,userId);
    }

}

