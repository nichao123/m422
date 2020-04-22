package Zrj326.src.main.java.pojo;

public class Foodinfo {
    private int foodId;
    private String foodName;
    private String remark;
    private int foodPrice;
    private String description;
    private String foodImage;
    public Foodinfo() {
    }
    public Foodinfo(int foodId, String foodName, String remark, int foodPrice, String description, String foodImage) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.remark = remark;
        this.foodPrice = foodPrice;
        this.description = description;
        this.foodImage = foodImage;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public int getFoodPrice() {
        return foodPrice;
    }
    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFoodImage() {
        return foodImage;
    }
    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
    @Override
    public String toString() {
        return  foodId + "\t" + foodName + "\t" + remark  + "\t" + foodPrice + "\t" + description  + "\t" + foodImage ;
    }
}
