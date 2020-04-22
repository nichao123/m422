package org.hlx.pojo;

import java.math.BigDecimal;

public class Foodinfo {
    private Integer foodid;

    private String foodname;

    private String remark;

    private BigDecimal foodprice;

    private String description;

    private String foodimage;

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(BigDecimal foodprice) {
        this.foodprice = foodprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage == null ? null : foodimage.trim();
    }
}