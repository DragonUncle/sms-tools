package top.dragon.service;

import top.dragon.job.ResultEntity;

import java.util.List;

public interface SmsMobileService {
    ResultEntity itemPhoneNumber(Integer itemId, Integer userId);

    //释放号码
    ResultEntity release(String phone, Integer userId);

    //拉黑号码
    ResultEntity black(String phone, Integer userId);

    ResultEntity addPhoneNumber(String phoneNumber, Integer userId);

    ResultEntity addPhoneNumbers(List<String> phoneNumbers, Integer userId);
}
