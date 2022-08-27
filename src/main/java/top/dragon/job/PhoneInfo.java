package top.dragon.job;

import lombok.Data;

@Data
public class PhoneInfo {
    //号码
    private String phone;

    //项目名
    private String name;

    //项目内容
    private String value;

    //所属用户
    private Integer uid;

    //等级
    private Integer level;

    //状态
    private Integer status;

    //是否是虚拟的
    private Boolean isVirtual;

    //使用者Id
    private Integer useUid;

}
