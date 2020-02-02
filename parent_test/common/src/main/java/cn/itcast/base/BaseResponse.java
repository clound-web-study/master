package cn.itcast.base;

import lombok.Data;

@Data
public class BaseResponse {
    private String code;
    private Object data;
    private String msg;
}
