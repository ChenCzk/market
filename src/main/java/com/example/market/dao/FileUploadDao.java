package com.example.market.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileUploadDao {

    // 添加图标
    @Insert("insert into icon_table(id,icon) values (#{id},#{icon})")
    void insertIcon(@Param("id")String id, @Param("icon")byte[] icon);

    // 添加图片
    @Insert("insert into photo_table(id,photo) values (#{id},#{photo})")
    void insertPhoto(@Param("id") String id, @Param("photo") byte[] photo);

    // 添加文档
    @Insert("insert into word_table(id,word) values (#{id},#{word})")
    void insertWord(@Param("id") String id, @Param("word") String word);



    // 根据ID查看Word
    @Select("Select word from word_table where id = #{id}")
    Object getWordByID(@Param("id") String id);

    // 根据ID删除图标
    @Select("DELETE FROM icon_table WHERE id = #{id};")
    void removeIconByID(String id);

    // 根据ID删除图片
    @Select("DELETE FROM photo_table WHERE id = #{id};")
    void removePhotoByID(@Param("id") String id);

    // 根据ID删除Word
    @Select("DELETE FROM word_table WHERE id = #{id};")
    void removeWordByID(String id);


    // 根据ID查看对应图片或图标
    @Select("Select photo from photo_table where id = #{id}")
    Object getPhotoByID(@Param("id") String id);
}
