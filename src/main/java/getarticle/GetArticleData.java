package getarticle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import getarticle.constants.Constants;
import getarticle.database.SummaryDataSaver;
import getarticle.dto.SummayDataDTO;
import getarticle.utils.AccessTokenUtils;
import getarticle.utils.HttpUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangjian on 17-3-26.
 */
@Service("getArticleData")
public class GetArticleData {
    @Resource
    SummaryDataSaver summaryDataSaver;
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
    public void saveArticleSummary(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray readList = jsonObject.getJSONArray("list");
        for(int i = 0;i<readList.size();i++){
            JSONObject data = readList.getJSONObject(i);
            SummayDataDTO summayDataDTO = JSONObject.toJavaObject(data,SummayDataDTO.class);
            try {
                summaryDataSaver.saveSummaryData(summayDataDTO);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
