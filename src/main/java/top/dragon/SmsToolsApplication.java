package top.dragon;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("top.dragon.mapper")
public class SmsToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsToolsApplication.class, args);
    }

}
