package getarticle;

import getarticle.utils.AccessTokenUtils;
import getarticle.utils.HttpUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjian on 17-3-26.
 */
public class Main {
    public static void main(String args[]) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("getarticle");
        GetArticleData getarticleData =  applicationContext.getBean(GetArticleData.class);
        Date startDate = simpleDateFormat.parse("2014-12-01");
        Date endDate = simpleDateFormat.parse("2017-03-01");
        while(!startDate.equals(endDate)){
            System.out.println(startDate);
            String resultJson = getarticleData.getArticleSummary(startDate);
            System.out.println(resultJson);
            getarticleData.saveArticleSummary(resultJson);
            startDate = DateUtils.addDays(startDate,1);
        }
    }
}
