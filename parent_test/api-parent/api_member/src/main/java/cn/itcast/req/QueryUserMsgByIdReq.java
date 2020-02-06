package cn.itcast.req;

import cn.itcast.base.BaseRequest;
import cn.itcast.utils.CommonTools;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotBlank;

@Data
@Slf4j
public class QueryUserMsgByIdReq extends BaseRequest {

    @NotBlank
    private String userId;
    @Override
    public void check() throws Exception {
        if(StringUtils.isEmpty(userId)){
            log.error("userID 为空");
            CommonTools.addError("userId 不能为空");
        }
    }
}
