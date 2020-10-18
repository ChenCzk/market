package com.example.market.domain.market;

import java.util.Arrays;

/**
 *  数据流项目类
 * */
public class MarketProject {
    private String MarketProjectID;     // 项目ID
    private String MarketProjectName;   // 项目名称
    private String iconIDList;        // 图标
    private String[] photoIDList;       // 图片
    private String wordIDList;        // word

    @Override
    public String toString() {
        return "MarketProject{" +
                "MarketProjectID='" + MarketProjectID + '\'' +
                ", MarketProjectName='" + MarketProjectName + '\'' +
                ", iconIDList='" + iconIDList + '\'' +
                ", photoIDList=" + Arrays.toString(photoIDList) +
                ", wordIDList='" + wordIDList + '\'' +
                '}';
    }

    public String getMarketProjectID() {
        return MarketProjectID;
    }

    public void setMarketProjectID(String marketProjectID) {
        MarketProjectID = marketProjectID;
    }

    public String getMarketProjectName() {
        return MarketProjectName;
    }

    public void setMarketProjectName(String marketProjectName) {
        MarketProjectName = marketProjectName;
    }

    public String getIconIDList() {
        return iconIDList;
    }

    public void setIconIDList(String iconIDList) {
        this.iconIDList = iconIDList;
    }

    public String[] getPhotoIDList() {
        return photoIDList;
    }

    public void setPhotoIDList(String[] photoIDList) {
        this.photoIDList = photoIDList;
    }

    public String getWordIDList() {
        return wordIDList;
    }

    public void setWordIDList(String wordIDList) {
        this.wordIDList = wordIDList;
    }
}
