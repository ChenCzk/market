package com.example.market.service;
import com.example.market.dao.uploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class uploadDaoServiceImpl implements uploadDaoService {
    @Autowired
    uploadDao  dao = null;

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
    public void insertWord(String id, byte[] word) {
        dao.insertWord(id,word);
    }
}
