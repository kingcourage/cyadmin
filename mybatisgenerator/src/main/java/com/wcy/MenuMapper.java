package com.wcy;

import com.wcy.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    @Insert({
        "insert into menu (id, parentid, ",
        "text, color, icon, ",
        "href, status, createtime, ",
        "updatetime, createid, ",
        "updateid)",
        "values (#{id,jdbcType=BIGINT}, #{parentid,jdbcType=BIGINT}, ",
        "#{text,jdbcType=VARCHAR}, #{color,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, ",
        "#{href,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{createid,jdbcType=BIGINT}, ",
        "#{updateid,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Long.class)
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, parentid, text, color, icon, href, status, createtime, updatetime, createid, ",
        "updateid",
        "from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    Menu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    @Update({
        "update menu",
        "set parentid = #{parentid,jdbcType=BIGINT},",
          "text = #{text,jdbcType=VARCHAR},",
          "color = #{color,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "href = #{href,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "createid = #{createid,jdbcType=BIGINT},",
          "updateid = #{updateid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Menu record);
}