package com.example.market.service;

public interface FileUploadDaoService {
    void insertPhoto(String id,byte[] b);
    void insertWord(String  id, String word);
    void insertIcon(String id, byte[] data);
    void removeIconByID(String id);
    void removePhotoByID(String id);
    void removeWordByID(String id);
}
