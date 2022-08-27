package top.dragon.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.dragon.job.ResultEntity;
import top.dragon.entity.SmsUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

/**
 * <p>
 * 用户列表 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
public interface SmsUserService extends IService<SmsUser> {

    ResultEntity login(String username, String password, String verCode, HttpServletRequest request, HttpServletResponse response);

    ResultEntity register(String username, String password, String surePassword, Integer userType, String phone, String email, String code, HttpServletRequest request);

    ResultEntity updatePassword(String username, String password, String surePassword);

    ResultEntity getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException;

    ResultEntity getUserInfo(Integer request);

    ResultEntity getInviteUser(Integer userId);
}
