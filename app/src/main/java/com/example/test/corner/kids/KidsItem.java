package com.example.test.corner.kids;

public class KidsItem {
    int kidsImages;
    String kidsTitle;
    String kidsPrice;
    String kidsId;

    public KidsItem(int kidsImages, String kidsTitle, String kidsPrice, String kidsId) {
        this.kidsImages = kidsImages;
        this.kidsTitle = kidsTitle;
        this.kidsPrice = kidsPrice;
        this.kidsId = kidsId;
    }

    public int getKidsImages() {
        return kidsImages;
    }

    public String getKidsTitle() {
        return kidsTitle;
    }

    public String getKidsPrice() {
        return kidsPrice;
    }

    public String getKidsId() {
        return kidsId;
    }
}

