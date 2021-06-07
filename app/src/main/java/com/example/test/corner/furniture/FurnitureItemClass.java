package com.example.test.corner.furniture;

public class FurnitureItemClass {
    int furnitureImages ;
    String furnitureTitle;
    String furniturePrice;
    String furnitureId;

    public FurnitureItemClass(int furnitureImages, String furnitureTitle,
                              String furniturePrice, String furnitureId) {
        this.furnitureImages = furnitureImages;
        this.furnitureTitle = furnitureTitle;
        this.furniturePrice = furniturePrice;
        this.furnitureId = furnitureId;
    }

    public int getFurnitureImages() {
        return furnitureImages;
    }

    public void setFurnitureImages(int furnitureImages) {
        this.furnitureImages = furnitureImages;
    }

    public String getFurnitureTitle() {
        return furnitureTitle;
    }

    public void setFurnitureTitle(String furnitureTitle) {
        this.furnitureTitle = furnitureTitle;
    }

    public String getFurniturePrice() {
        return furniturePrice;
    }

    public void setFurniturePrice(String furniturePrice) {
        this.furniturePrice = furniturePrice;
    }

    public String getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(String furnitureId) {
        this.furnitureId = furnitureId;
    }
}
