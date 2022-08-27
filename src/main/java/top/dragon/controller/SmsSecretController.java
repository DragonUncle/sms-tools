package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsSecretService;

/**
 * <p>
 * 卡密 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/secret")
public class SmsSecretController {

    @Resource
    private SmsSecretService secretService;

    //生成卡密
    @RequestMapping("/create")
    public ResultEntity create(Integer number, Integer money, HttpServletRequest request) {
        //Integer userId = Integer.parseInt(request.getHeader("userId"));
        Integer userId =10000;
        try{
            return secretService.create(number, money, userId);
        }catch (Exception e) {
            return ResultEntity.error( "生成卡密失败");
        }
    }
    //查询卡密
    @RequestMapping("/select")
    public ResultEntity select(Integer page, Integer size,Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return secretService.select(page, size, type,userId);
    }
    //查询所有卡密
    @RequestMapping("/selectAll")
    public ResultEntity selectAll(Integer page, Integer size,Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return secretService.selectAll(page, size, type,userId);
    }
    //删除卡密
    @RequestMapping("/delete")
    public ResultEntity delete(Integer id, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return secretService.delete(id,userId);
    }
    //回收卡密
    @RequestMapping("/recycle")
    public ResultEntity recycle(Integer id, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return secretService.recycle(id,userId);
    }
    //使用卡密
    @RequestMapping("/use")
    public ResultEntity use(String secretCard, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return secretService.use(secretCard,userId);
    }

}

