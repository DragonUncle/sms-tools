package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsNoticeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/notice")
public class SmsNoticeController {

    @Resource
    private SmsNoticeService noticeService;

    @RequestMapping("/select")
    public ResultEntity selectAll( Integer type, HttpServletRequest request) {
        return noticeService.selectAll( type);
    }
/**    //添加公告
    @RequestMapping("/add")
    public ResultEntity add(Integer noticeType,String noticeName,String noticeValue, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return noticeService.add(noticeType,noticeName,noticeValue,userId);
    }**/

    //删除公告
    @RequestMapping("/delete")
    public ResultEntity delete(Integer noticeId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return noticeService.delete(noticeId,userId);
    }


}

