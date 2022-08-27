package top.dragon.controller;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dragon.job.ResultEntity;
import top.dragon.service.SmsMobileService;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class SmsMobileController {
    @Resource
    private SmsMobileService mobileService;


    //获取号码
    @RequestMapping("/itemPhoneNumber")
    public ResultEntity itemPhoneNumber(Integer itemId, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return mobileService.itemPhoneNumber(itemId,userId);
    }
    //加入账号
    @RequestMapping("/addPhoneNumber")
    public ResultEntity addPhoneNumber( String phoneNumber, HttpServletRequest request) {
        //Integer userId = Integer.parseInt(request.getHeader("userId"));
        Integer userId = null;
        return mobileService.addPhoneNumber(phoneNumber,userId);
    }

    @RequestMapping("/addPhoneNumbers")
    public ResultEntity addPhoneNumbers(@RequestBody List<String> phoneNumbers, HttpServletRequest request) {
        Integer userId = Integer.parseInt(request.getHeader("userId"));
        return mobileService.addPhoneNumbers(phoneNumbers,userId);
    }


}
