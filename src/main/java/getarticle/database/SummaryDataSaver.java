package getarticle.database;

import getarticle.dto.SummayDataDTO;
import getarticle.utils.DataBaseUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by WangJian on 2017/3/29.
 */
@Component
public class SummaryDataSaver {
    public void saveSummaryData(SummayDataDTO data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO `wechat`.`summary_data`\n" +
                "(`ref_date`,\n" +
                "`user_source`,\n" +
                "`msgid`,\n" +
                "`title`,\n" +
                "`int_page_read_user`,\n" +
                "`int_page_read_count`,\n" +
                "`ori_page_read_user`,\n" +
                "`ori_page_read_count`,\n" +
                "`share_user`,\n" +
                "`share_count`,\n" +
                "`add_to_fav_user`,\n" +
                "`add_to_fav_count`)\n" +
                "VALUES\n" +
                "(\'"+ simpleDateFormat.format(data.getRef_date()) +"\',\n" +
                ""+data.getUser_source()+" ,\n" +
                "\'"+data.getMsgid()+"\' ,\n" +
                "\'"+data.getTitle()+"\',\n" +
                ""+data.getInt_page_read_user()+",\n" +
                ""+data.getInt_page_read_count()+",\n" +
                ""+data.getOri_page_read_user()+",\n" +
                ""+data.getOri_page_read_count()+",\n" +
                ""+data.getShare_user()+",\n" +
                ""+data.getShare_count()+",\n" +
                ""+data.getAdd_to_fav_user()+",\n" +
                ""+data.getAdd_to_fav_count()+");\n";
        DataBaseUtils.insertDB(sql);
    }
}
