package getarticle.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import getarticle.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjian on 17-3-26.
 */
public class AccessTokenUtils {
    private static String accessToken;
    private static long expiresIn;
    private static final long timeMargin = 1000;

    public static String getAccessToken() {
        long currentTimeMills = System.currentTimeMillis();
        if (currentTimeMills < expiresIn - timeMargin) {
            return accessToken;
        }
        Map<String,String> parameters = new HashMap<String, String>();
        parameters.put("grant_type","client_credential");
        parameters.put("appid", Constants.appid);
        parameters.put("secret",Constants.secret);
        String resultJson = HttpUtils.sendGet(Constants.accessTokenURL,parameters);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        accessToken = jsonObject.getString("access_token");
        expiresIn = System.currentTimeMillis()+jsonObject.getLong("expires_in");
        return accessToken;
    }

}
