package com.lquan.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lquan
 * @create 2022- 11-26 下午11:05
 * @description
 */
@ConfigurationProperties(prefix = "mybus")
public class Bus {


    /**
     * brand : Benz
     * price : 10
     */

    private String brand;
    private int price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
