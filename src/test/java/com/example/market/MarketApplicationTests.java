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
      //  byte[] photo = (byte[]) dao.getPhotoByID("14ec806f-eb28-4b9d-9a62-2a42ff298197");
       byte[] photo = (byte[]) dao.getWordByID("334cf1bf-2cd6-4ef2-9ff8-3c1aff8f0e56");

        BASE64Encoder encoder = new BASE64Encoder();
        String image = encoder.encode(photo);

        if(image!=null && !"AA==".equals(image)){

            String header = "data:image/jpeg;base64,";

            image = header+image;
        }
        System.out.println(image);
    }

}
