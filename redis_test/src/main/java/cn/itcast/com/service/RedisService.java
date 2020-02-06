package cn.itcast.com.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,String value){
        setObject(key,value,null);
    }

    public void setString(String key,String value,Long time){
        setObject(key,value,time);
    }

    public void setObject(String key,Object value,Long time){
        if(StringUtils.isEmpty(key)||value==null){
            return;
        }
        if(value instanceof String){
            stringRedisTemplate.opsForValue().set(key,(String)value);
            if(time != null){
                stringRedisTemplate.opsForValue().set(key,(String)value,time, TimeUnit.SECONDS);
            }
            return;
        }
        if(value instanceof List){
            List<String> list = (List<String>)value;
            for(String str:list){
                stringRedisTemplate.opsForList().leftPush(key,str);
            }
            return;
        }
    }

    public String getStringKey(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

}
