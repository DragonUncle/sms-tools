package top.dragon.job;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeviceInfo {

    private String name;

    private String ip;

    private LocalDateTime lastTime;

    private String version;

    private String deviceId;

    private String remark;

    private Integer uid;

    private LocalDateTime createTime;

    private Integer number;

    private List<String> cards;

}
