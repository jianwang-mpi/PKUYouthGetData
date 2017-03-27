package getarticle;

import com.alibaba.fastjson.JSONObject;
import getarticle.constants.Constants;
import getarticle.utils.AccessTokenUtils;
import getarticle.utils.HttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjian on 17-3-26.
 */
public class GetArticleData {
    public String getArticleSummary(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(date);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",dateString);
        jsonObject.put("end_date",dateString);
        System.out.println(jsonObject.toJSONString());
        String accessToken = AccessTokenUtils.getAccessToken();
        Map<String,String> parameters = new HashMap<String, String>();
        parameters.put("access_token",accessToken);
        String resultJson = HttpUtils.sendPost(Constants.getArticleSummaryURL,parameters,jsonObject);
        return resultJson;
    }
}
