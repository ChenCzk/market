package com.example.market;

import com.example.market.dao.uploadDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;


@SpringBootTest
@RunWith(SpringRunner.class)
class MarketApplicationTests {

    @Autowired
    uploadDao dao = null;

    @Test
    void contextLoads() {
        byte[] photo = (byte[]) dao.getPhotoByID("cbd52323-7933-4f7e-89d1-bf0e9389ffa9");

        BASE64Encoder encoder = new BASE64Encoder();
        String image = encoder.encode(photo);

        if(image!=null && !"AA==".equals(image)){

            String header = "data:image/jpeg;base64,";

            image = header+image;
        }
        System.out.println(image);
    }

}
