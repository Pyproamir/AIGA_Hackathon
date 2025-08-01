package com.example.aiga_hackathon.client.buy;

import com.google.gson.annotations.SerializedName;

public class ShopModel {
    @SerializedName("product_image")
    private int image;
    @SerializedName("product_name")
    private String name;
    @SerializedName("product_cost")
    private float cost;
    @SerializedName("product_isNew")
    private boolean isNew;
    @SerializedName("product_delivery_cost")
    private float deliveryCost;
    @SerializedName("product_delivery_city")
    private String deliveryCity;
    @SerializedName("product_desc")
    private String desc;

    public ShopModel(int image, String name, float cost, boolean isNew, float deliveryCost, String deliveryCity, String desc) {
        this.image = image;
        this.name = name;
        this.cost = cost;
        this.isNew = isNew;
        this.deliveryCost = deliveryCost;
        this.deliveryCity = deliveryCity;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public float getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(float deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
