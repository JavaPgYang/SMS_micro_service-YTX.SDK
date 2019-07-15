package design.pgy.sms;

import design.pgy.sms.sdk.CCPRestSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class SmsUtil {

    @Autowired
    private Environment env;

    public void sendSms(Map<String, String> paramMap) {
        HashMap<String, Object> result = null;

        CCPRestSDK restAPI = new CCPRestSDK();
        restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		
        restAPI.setAccount(env.getProperty("accountSid"), env.getProperty("accountToken"));// 初始化主帐号和主帐号TOKEN
		
        restAPI.setAppId("8aaf07086bdeb007016bf0a48c9b0a32");// 初始化应用ID
		
        result = restAPI.sendTemplateSMS(paramMap.get("phone"), paramMap.get("templateld"), new String[]{paramMap.get("code"), paramMap.get("time")});

        System.out.println("SDKTestSendTemplateSMS result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
    }

}
