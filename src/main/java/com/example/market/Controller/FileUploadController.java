package com.example.market.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.market.dao.FileUploadDao;
import com.example.market.service.FileUploadDaoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.UUID;

@Controller
@MapperScan("com.example.market.dao")
public class FileUploadController {

    @Autowired
    FileUploadDaoService fileUploadService = null;

    @RequestMapping("/upload")
    public String upload() {
        return "/page/upload.html";
    }


    /*
     * 入库 图片
     * @param file 图片
     * @return 对应生成的ID
     */
    @RequestMapping("/uploadPhoto")
    @ResponseBody
    public String uploadPhoto(MultipartFile file) {
        String id = null;
        try {
            byte[] data = file.getBytes();
            // 入库
            id = UUID.randomUUID().toString();
            fileUploadService.insertIcon(id, data);
            System.out.println(file.getName());
            JSONObject object = new JSONObject();
            object.put("id", id);
            return object.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * 入库 图标
     * @param file 图标
     * @return 对应生成的ID
     */
    @RequestMapping("/uploadIcon")
    @ResponseBody
    public String uploadIcon(MultipartFile file) {
        String id = null;
        try {
            byte[] data = file.getBytes();
            // 入库
            id = UUID.randomUUID().toString();
            fileUploadService.insertPhoto(id, data);
            System.out.println(file.getOriginalFilename());
            JSONObject object = new JSONObject();
            object.put("id", id);
            return object.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * 入库 Word文档
     * @param WordStr Word文档
     * @return 对应生成的ID
     */
    @RequestMapping("/uploadWord")
    @ResponseBody
    public String uploadWord(@RequestBody String WordStr) {
        // 存入数据库
        String id = null;
        try {
            id = UUID.randomUUID().toString();
            String decode = URLDecoder.decode(WordStr, "UTF-8");
            System.out.println(decode);
            // 入库
            fileUploadService.insertWord(id, decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 删除图标
     */
    @RequestMapping("/removeIconByID")
    @ResponseBody
    public void removeIconByID(String id) {
        try {
            fileUploadService.removeIconByID(id);
        } catch (Exception ex) {

        }
    }

    /**
     * 删除图片
     */
    @RequestMapping("/removePhotoByID")
    @ResponseBody
    public void removePhotoByID(String id) {
        try {
            fileUploadService.removePhotoByID(id);
        } catch (Exception ex) {

        }
    }

    /**
     * 删除Word文档
     */
    @RequestMapping("/removeWordByID")
    @ResponseBody
    public void removeWordByID(String id) {
        try {
            fileUploadService.removeWordByID(id);
        } catch (Exception ex) {
        }
    }

    @Autowired
    FileUploadDao dao = null;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        String photo = (String) dao.getWordByID("bb357b31-8a19-45b6-9a30-5bb6e25fa02d");
        return photo;
    }


}
