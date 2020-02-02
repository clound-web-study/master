package cn.itcast.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BaseController implements Serializable {

    private static final long serialVersionUID = 5494875772424381242L;

    public BaseResponse getSucMessage(Object obj){
        BaseResponse response = new BaseResponse();
        response.setCode("200");
        response.setMsg("success");
        response.setData(obj);
        return response;
    }

    public BaseResponse getErrorMessage(Object obj){
        BaseResponse response = new BaseResponse();
        response.setCode("500");
        response.setMsg(JSONObject.toJSONString(obj));
        return response;
    }

    public BaseResponse getError(){
        BaseResponse response = new BaseResponse();
        response.setCode("500");
        response.setMsg("error");
        return response;
    }
}
