package com.spring.domain;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class Computer {

    //电脑品牌
    private String brand;
    //电脑型号
    private String name;
    //电脑价格
    private Float price;

    public Computer() {}
    public Computer(String brand, String name, Float price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

}
