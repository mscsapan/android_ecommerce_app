package com.example.test.corner.female;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class FemaleModel {
    private int fImages;
    private String fTitle;
    private String fPrice;
    private String fId;

    public FemaleModel(int fImages, String fTitle, String fPrice, String fId) {
        this.fImages = fImages;
        this.fTitle = fTitle;
        this.fPrice = fPrice;
        this.fId = fId;
    }

    public int getfImages() {
        return fImages;
    }

    public String getfTitle() {
        return fTitle;
    }

    public String getfPrice() {
        return fPrice;
    }

    public String getfId() {
        return fId;
    }

}
