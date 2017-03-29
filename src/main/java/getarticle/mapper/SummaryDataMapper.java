package getarticle.mapper;

import getarticle.dto.SummayDataDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by WangJian on 2017/3/28.
 */
@Mapper
public interface SummaryDataMapper {
    @Insert("INSERT INTO `wechat`.`summary_data`\n" +
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
            "(<{ref_date: data.ref_date}>,\n" +
            "<{user_source:data.user_source }>,\n" +
            "<{msgid:data.msgid }>,\n" +
            "<{title:data.title }>,\n" +
            "<{int_page_read_user: data.int_page_read_user}>,\n" +
            "<{int_page_read_count: data.int_page_read_count}>,\n" +
            "<{ori_page_read_user: data.ori_page_read_user}>,\n" +
            "<{ori_page_read_count: data.ori_page_read_count}>,\n" +
            "<{share_user: data.share_user}>,\n" +
            "<{share_count:data. share_count}>,\n" +
            "<{add_to_fav_user: data.add_to_fav_user}>,\n" +
            "<{add_to_fav_count: data.add_to_fav_count}>);\n")
    void saveSummaryData(@Param("data") SummayDataDTO summayDataDTO);
}
