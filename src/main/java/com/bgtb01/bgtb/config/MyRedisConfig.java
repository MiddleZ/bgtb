package com.bgtb01.bgtb.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration //声明为配置类
public class MyRedisConfig {
    @Resource//注入Redis连接工厂
    private RedisConnectionFactory factory;

    @Bean   //创建一个Bean,Spring会自动管理这个Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();//创建一个RedisTemplate对象
        redisTemplate.setConnectionFactory(factory); //设置连接工厂

        redisTemplate.setKeySerializer(new StringRedisSerializer());//设置键的序列化方式

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);//创建一个Jackson2JsonRedisSerializer对象，用于序列化和反序列化



        ObjectMapper om = new ObjectMapper();//创建一个ObjectMapper对象，用于处理JSON
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);// 设置所有属性都可见
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); // 设置日期格式
        om.setTimeZone(TimeZone.getDefault());// 设置时区
        om.configure(MapperFeature.USE_ANNOTATIONS, false);// 设置不使用注解
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 设置反序列化时忽略未知属性
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// 设置序列化时忽略空的Bean
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);// 设置默认的类型信息
        serializer.setObjectMapper(om);// 设置ObjectMapper
        //String的序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//
        //key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //value序列化方式采用jackson
        redisTemplate.setKeySerializer(serializer);
        //hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(serializer);
        //redisTemplate.afterPropertiesSet();
        return redisTemplate; // 返回RedisTemplate对象
    }

}
