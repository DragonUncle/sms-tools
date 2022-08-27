package top.dragon;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class SmsToolsApplicationTests {


    @Test
    void contextLoads() {


        HashMap<Integer, String[]> stringHashMap = new HashMap<>();
        stringHashMap.put(1,new String[]{"14752169639,13018627453"});






    }

}
