package com.msh.furn.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@TableName("furn")//和表名映射
public class Furn {
    private Integer id;
    @NotEmpty(message = "請輸入家居名")
    private String name;
    @NotEmpty(message = "請輸入廠商名")
    private String maker;
    @NotNull(message = "請輸入數字")
    @Range(min = 0,message = "價格不能小於零")
    private Double price;
    @NotNull(message = "請輸入數字")
    @Range(min = 0,message = "銷量不能小於零")
    private Integer sales;
    @NotNull(message = "請輸入數字")
    @Range(min = 0,message = "庫存不能小於零")
    private Integer stock;

    public Furn() {
    }

    public Furn(Integer id, String name, String maker, Double price, Integer sales, Integer stock) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
