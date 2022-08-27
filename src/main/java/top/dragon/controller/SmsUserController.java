package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsUserService;

import java.io.IOException;

/**
 * <p>
 * 用户列表 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/user")
public class SmsUserController {
    @Resource
    private SmsUserService userService;
    // 用户登录
    @RequestMapping("/login")
    public ResultEntity login(String username, String password, String code,HttpServletRequest request,HttpServletResponse response) {
        return userService.login(username,password,code,request,response);
    }
    // 用户注册
    @RequestMapping("/register")
    public ResultEntity register(String username, String password, String surePassword,Integer userType,String phone,String email,String code,HttpServletRequest request) {
        return userService.register(username,password,surePassword,userType,phone,email,code,request);
    }
    // 用户修改密码
    @RequestMapping("/updatePassword")
    public ResultEntity updatePassword(String username, String password, String surePassword) {
        return userService.updatePassword(username,password,surePassword);
    }
    //生成图片验证码
    @RequestMapping("/getImageCode")
    public ResultEntity getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return userService.getImageCode(request,response);
    }
    //获取个人信息
    @RequestMapping("/getUserInfo")
    public ResultEntity getUserInfo(HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return userService.getUserInfo(userId);
    }
    //获取用户列表
    @RequestMapping("/getInviteUser")
    public ResultEntity getInviteUser(HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return userService.getInviteUser(userId);
    }

}

