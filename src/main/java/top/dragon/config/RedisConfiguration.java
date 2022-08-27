package top.dragon.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;


@Configuration
@EnableAutoConfiguration
public class RedisConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);
    /**
     * 配置redisTemplate
     //    * @param lettuceConnectionFactory lettuceConnection工厂
     * @return 配置成功返回可以使用RedisTemplate<String, Object> 类型
     */
    public  RedisTemplate<String, Object> redisTemplate(Integer database) {
        // 设置序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //配置redis
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setPassword("");
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        lettuceConnectionFactory.afterPropertiesSet();
        //配置连接池
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
        // key序列化
        redisTemplate.setKeySerializer(stringSerializer);
        // value序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // Hash key序列化
        redisTemplate.setHashKeySerializer(stringSerializer);
        // Hash value序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        logger.info("redis初始化信息:{}", redisTemplate);
        return redisTemplate;
    }

    @Bean(name = "systemRedisTemplate")
    @Primary
    public RedisTemplate<String, Object> redisTemplate() {
        return redisTemplate(0);
    }
    @Bean(name = "userRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate1() {
        return redisTemplate(1);
    }
    @Bean(name = "phoneRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate2() {
        return redisTemplate(2);
    }
    @Bean(name = "messageRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate3() {
        return redisTemplate(3);
    }
    @Bean(name = "redisTemplate4")
    public RedisTemplate<String, Object> redisTemplate4() {
        return redisTemplate(4);
    }
    @Bean(name = "redisTemplate5")
    public RedisTemplate<String, Object> redisTemplate5() {
        return redisTemplate(5);
    }
    @Bean(name = "redisTemplate6")
    public RedisTemplate<String, Object> redisTemplate6() {
        return redisTemplate(6);
    }
    @Bean(name = "redisTemplate7")
    public RedisTemplate<String, Object> redisTemplate7() {
        return redisTemplate(7);
    }
}
