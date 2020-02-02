package cn.itcast.service.impl;

import cn.itcast.base.BaseController;
import cn.itcast.base.BaseResponse;
import cn.itcast.redis.RedisService;
import com.itcast.cn.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/member")
public class ApiTestServiceI extends BaseController implements IMemberService {

    @Autowired
    private RedisService redisService;
    @RequestMapping("/login")
    @Override
    public BaseResponse showLoginUser(String name, String tel) {
        String userMap = redisService.getStringKey("userMap");
        if(StringUtils.isNotEmpty(userMap)){
            return getSucMessage(userMap);
        }
        Map<String,String> map= new HashMap<>();
        map.put("name",name);
        map.put("tel",tel);
        redisService.setObject("userMap",map,1000l);
        return getSucMessage(map);
    }
}
