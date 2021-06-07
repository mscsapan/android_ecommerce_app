package com.example.test.corner.journey;

public class JourneyModel {
    private int images;
    private String title;
    private String id;
    private String price;

    public JourneyModel(int images, String title, String id, String price) {
        this.images = images;
        this.title = title;
        this.id = id;
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }
}
