package com.example.market.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface uploadDaoService {
    void insertPhoto(String id,byte[] b);
    void insertWord(String  id, byte[] word);
}
