package cn.itcast.controller;

import cn.itcast.base.BaseController;
import cn.itcast.dao.UserDao;
import cn.itcast.model.Users;
import cn.itcast.redis.RedisService;
import cn.itcast.req.QueryUserMsgByIdReq;
import cn.itcast.resp.QueryUserMsgByIdResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
public class UserController extends BaseController {

    @Autowired
    private RedisService redisService;
    @Resource
    private UserDao userDao;
    @RequestMapping(path="/test",method = RequestMethod.POST)
    public QueryUserMsgByIdResp test(@RequestBody QueryUserMsgByIdReq req){
        QueryUserMsgByIdResp resp = new QueryUserMsgByIdResp();
        Users userById = userDao.getUserById(req.getUserId());
        return getSucMessage(resp,userById);
    }
}
