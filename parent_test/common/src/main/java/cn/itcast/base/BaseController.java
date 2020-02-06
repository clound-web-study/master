package cn.itcast.base;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseController implements Serializable {

    private static final long serialVersionUID = 5494875772424381242L;

    public <T extends BaseResponse> T getSucMessage(T response,Object obj){
        response.setCode("200");
        response.setMsg("success");
        response.setData(obj);
        return response;
    }

    public <T extends BaseResponse> T getErrorMessage(T response,Object obj){
        response.setCode("500");
        response.setMsg(JSONObject.toJSONString(obj));
        return response;
    }

    public <T extends BaseResponse> T getError(T response){
        response.setCode("500");
        response.setMsg("error");
        return response;
    }
}
