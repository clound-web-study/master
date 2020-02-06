package cn.itcast.dao;

import cn.itcast.model.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    Users getUserById(String userId);
}
