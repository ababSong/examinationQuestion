package test;

import java.math.BigDecimal;

public class Fruits {

    private int id;
    private String name;
    private BigDecimal price;

    private String discount;
    /**
     * 是否开启折扣
     */
    private int discount_flag=0;

    public Fruits(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Fruits(int id, String name, BigDecimal price, String discount, int discount_flag) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.discount_flag = discount_flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getDiscount_flag() {
        return discount_flag;
    }

    public void setDiscount_flag(int discount_flag) {
        this.discount_flag = discount_flag;
    }
}
