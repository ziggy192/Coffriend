package com.ziggy.coffriend.model;

public class CoffeeShop {
    private int backgroundImg,locationImg;
    private String coffeeName,coffeeAddress;

    public CoffeeShop() {
    }

    public CoffeeShop(int backgroundImg, int locationImg, String coffeeName, String coffeeAddress) {
        this.backgroundImg = backgroundImg;
        this.locationImg = locationImg;
        this.coffeeName = coffeeName;
        this.coffeeAddress = coffeeAddress;
    }

    public int getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(int backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public int getLocationImg() {
        return locationImg;
    }

    public void setLocationImg(int locationImg) {
        this.locationImg = locationImg;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeAddress() {
        return coffeeAddress;
    }

    public void setCoffeeAddress(String coffeeAddress) {
        this.coffeeAddress = coffeeAddress;
    }
}
