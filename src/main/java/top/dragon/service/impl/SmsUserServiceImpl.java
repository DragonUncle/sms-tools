package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsUser;
import top.dragon.mapper.SmsUserMapper;
import top.dragon.service.SmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dragon.utils.GenerateCode;
import top.dragon.utils.JwtUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * <p>
 * 用户列表 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@Service
public class SmsUserServiceImpl extends ServiceImpl<SmsUserMapper, SmsUser> implements SmsUserService {

    @Override
    public ResultEntity login(String username, String password, String verCode, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("登录的Id="+request.getSession().getId());
        if (StringUtils.isAnyBlank(username, password)) {
            return ResultEntity.error("用户名或密码不能为空");
        }
        Object code1 = request.getSession().getAttribute("code");
        if (code1 == null) {
            return ResultEntity.error("验证码已过期");
        }
        if (!verCode.toUpperCase().equals(code1)) {
            return ResultEntity.error("验证码错误");
        }
        SmsUser user = this.getOne(new QueryWrapper<SmsUser>().
                eq("user_account", username).eq("user_is_del",false));
        if (user == null) {
            return ResultEntity.error("用户不存在");
        }
        String encodeToString = Base64.getEncoder().encodeToString(password.getBytes());
        if (!user.getUserPassword().equals(encodeToString)) {
            return ResultEntity.error("密码错误");
        }
        user.setUserPassword(null);
        JwtUtils jwtUtils = new JwtUtils();
        String jwtToken = jwtUtils.createJwtToken(259200000L, user.getUserId().longValue());
        response.addHeader("Authorization",  jwtToken);
        user.setUserKey(jwtToken);
        return ResultEntity.succeed(user);
    }

    @Override
    public ResultEntity register(String username, String password, String surePassword, Integer userType, String phone, String email, String code, HttpServletRequest request) {
        if (StringUtils.isAnyBlank(username, password, surePassword, phone,  code)) {
            return ResultEntity.error("用户名或密码、超级密码、联系方式、验证码不能为空");
        }
        Object code1 = request.getSession().getAttribute("code");
        if (code1 == null) {
            return ResultEntity.error("验证码已过期");
        }
        if (!code.toUpperCase().equals(code1)) {
            return ResultEntity.error("验证码错误");
        }
        SmsUser smsUser = this.getOne(new QueryWrapper<SmsUser>().eq("user_account", username).eq("user_is_del",false));
        if (smsUser != null) {
            return ResultEntity.error("用户名已存在");
        }
        String encodeToString = Base64.getEncoder().encodeToString(password.getBytes());
        SmsUser user = new SmsUser();
        user.setUserType(userType);
        user.setUserAccount(username);
        user.setUserPassword(encodeToString);
        user.setUserSuperPassword(surePassword);
        user.setUserContact(phone);
        user.setUserPid(Integer.parseInt(email));
        user.setUserIsDel(false);
        user.setUserCreateTime(LocalDateTime.now());
        return  ResultEntity.isValid(this.save(user),"注册成功","注册失败");
    }

    @Override
    public ResultEntity updatePassword(String username, String password, String surePassword) {
        if (StringUtils.isAnyBlank(username, password, surePassword)) {
            return ResultEntity.error("用户名或密码不能为空");
        }
        SmsUser smsUser = this.getOne(new QueryWrapper<SmsUser>().eq("user_account", username).eq("user_is_del",false));
        if (smsUser == null) {
            return ResultEntity.error("用户名不存在");
        }
        if (!smsUser.getUserSuperPassword().equals(surePassword)){
            return ResultEntity.error("超级密码错误");
        }
        String encodeToString = Base64.getEncoder().encodeToString(password.getBytes());
        smsUser.setUserPassword(encodeToString);
        return ResultEntity.isValid(this.updateById(smsUser));
    }

    @Override
    public ResultEntity getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("生成验证码的Id="+request.getSession().getId());
        //生成验证码图片
        String s = GenerateCode.generateVerifyCode(5);
        request.getSession().setAttribute("code", s);
        GenerateCode.outputImage(300,100,response.getOutputStream(),s);
        return ResultEntity.succeed();
    }

    @Override
    public ResultEntity getUserInfo(Integer request) {
        return null;
    }

    @Override
    public ResultEntity getInviteUser(Integer userId) {
        return null;
    }
}
