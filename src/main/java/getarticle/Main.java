package getarticle;

import getarticle.utils.AccessTokenUtils;
import getarticle.utils.HttpUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjian on 17-3-26.
 */
public class Main {
    public static void main(String args[]) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(new GetArticleData().getArticleSummary(simpleDateFormat.parse("2014-12-08")));
    }
}
