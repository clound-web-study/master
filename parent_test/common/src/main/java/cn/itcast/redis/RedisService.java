package cn.itcast.redis;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
        if(value == null){
            if(time == null){
                stringRedisTemplate.opsForValue().set(key,null);
            }else{
                stringRedisTemplate.opsForValue().set(key,null,time,TimeUnit.SECONDS);
            }
        }else{
            if(time == null){
                stringRedisTemplate.opsForValue().set(key,JSONObject.toJSONString(value));
            }else{
                stringRedisTemplate.opsForValue().set(key,JSONObject.toJSONString(value),time,TimeUnit.SECONDS);
            }
        }
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public <T> T getObject(String key,T t){
        String str = stringRedisTemplate.opsForValue().get(key);
        if(StringUtils.isNotEmpty(str)){
            return (T)JSONObject.parse(str);
        }
        return null;
    }

    public void delere(String key){
        stringRedisTemplate.delete(key);
    }

}
