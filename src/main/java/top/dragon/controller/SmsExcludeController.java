package top.dragon.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsExcludeService;

/**
 * <p>
 * 剔除项目 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/exclude")
public class SmsExcludeController {

    @Autowired
    private SmsExcludeService excludeService;

    //查询所有剔除项目
    @RequestMapping("/selectAll")
    public ResultEntity selectAll(Integer page, Integer size, Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return excludeService.selectAll(page, size, type,userId);
    }
    //添加剔除的项目
    @RequestMapping("/add")
    public ResultEntity add(Integer projectId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return excludeService.add(projectId,userId);
    }
    @RequestMapping("/delete")
    public ResultEntity delete(Integer projectId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return excludeService.delete(projectId,userId);
    }

}

