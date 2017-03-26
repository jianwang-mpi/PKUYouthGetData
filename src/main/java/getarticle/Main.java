package getarticle;

import getarticle.utils.HttpUtils;

/**
 * Created by wangjian on 17-3-26.
 */
public class Main {
    public static void main(String args[]) {
        String result = HttpUtils.sendGet("http://www.sina.com", null);
        System.out.println(result);
    }
}
