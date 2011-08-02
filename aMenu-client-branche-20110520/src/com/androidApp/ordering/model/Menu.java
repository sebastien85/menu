package com.androidApp.ordering.model;

public class Menu {
    
    /**
     * 名称
     */
    private String menuName;
    
    /**
     * 简介
     */
    private String menuInfo;
    
    /**
     * 单价
     */
    private float menuPrice;
    
    /**
     * 图片
     */
    private String menuImage;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(String menuInfo) {
        this.menuInfo = menuInfo;
    }

    public float getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(float menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

}
