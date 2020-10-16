package com.example.market.service;
import com.example.market.dao.FileUploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *  图标、图片、文件 上传 Service
 * */
@Service
public class FileUploadDaoServiceImpl implements FileUploadDaoService {
    @Autowired
    FileUploadDao dao = null;

    /**
     *  添加图标
     * */
    @Override
    public void insertIcon(String id, byte[] data) {
        dao.insertIcon(id,data);
    }

    /**
    *  添加图片
    * */
    @Override
    public void insertPhoto(String id, byte[] b) {
         dao.insertPhoto(id,b);
    }

    /**
     *  添加文档
     * */
    @Override
    public void insertWord(String id, String word) {
        dao.insertWord(id,word);
    }

    /**、
     *  删除图标
     * */
    @Override
    public void removeIconByID(String id) {
        dao.removeIconByID(id);
    }

    /**
     *  删除图片
     * */
    @Override
    public void removePhotoByID(String id) {
        dao.removePhotoByID(id);
    }

    /**
     *  删除文档
     * */
    @Override
    public void removeWordByID(String id) {
        dao.removeWordByID(id);
    }
}
