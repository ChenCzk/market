package com.example.market.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.market.service.uploadDaoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;

@Controller
@MapperScan("com.example.market.dao")
public class UploadController {

    @Autowired
    uploadDaoService uploadservice = null;

    @RequestMapping("/upload")
    public String upload() {

        return "/page/upload.html";

    }


    /*
     * 用于接收图片和图标，入库
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
            uploadservice.insertPhoto(id, data);
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
     * 用于接收上传的word文档
     * @param file 图片
     * @return 对应生成的ID
     */
    @RequestMapping("/uploadWord")
    @ResponseBody
    public String uploadWord(MultipartFile file) {
        // 存入数据库

        String id = null;
        try {
            byte[] bytes = file.getBytes();

            id = UUID.randomUUID().toString();
            // 入库
            uploadservice.insertWord(id, bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回id
        return id;
    }


}
