package com.itcast.cn.service;


import cn.itcast.base.BaseResponse;

public interface IMemberService {

    BaseResponse showLoginUser(String name, String tel);
}
