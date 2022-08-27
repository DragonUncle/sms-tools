package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsExclusiveService;

/**
 * <p>
 * 专属 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/exclusive")
public class SmsExclusiveController {

    @Resource
    private SmsExclusiveService exclusiveService;

    //查询所有专属
    @RequestMapping("/selectAll")
    public ResultEntity selectAll(Integer page, Integer size, Integer type, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return exclusiveService.selectAll(page, size, type,userId);
    }
    //添加专属
    @RequestMapping("/add")
    public ResultEntity add(Integer projectId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return exclusiveService.add(projectId,userId);
    }
    //删除专属
    @RequestMapping("/delete")
    public ResultEntity delete(Integer projectId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return exclusiveService.delete(projectId,userId);
    }

}

