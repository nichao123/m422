package Zrj326.src.main.java.pojo;

public class Foodorderinfo {
    private int orderId;
    private int userId;
    private int foodId;
    private int sl;
    private String dcdate;
    private int subprice;
    public Foodorderinfo() {
    }
    public Foodorderinfo(int orderId, int userId, int foodId, int sl, String dcdate, int subprice) {
        this.orderId = orderId;
        this.userId = userId;
        this.foodId = foodId;
        this.sl = sl;
        this.dcdate = dcdate;
        this.subprice = subprice;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public int getSl() {
        return sl;
    }
    public void setSl(int sl) {
        this.sl = sl;
    }
    public String getDcdate() {
        return dcdate;
    }
    public void setDcdate(String dcdate) {
        this.dcdate = dcdate;
    }
    public int getSubprice() {
        return subprice;
    }
    public void setSubprice(int subprice) {
        this.subprice = subprice;
    }
    @Override
    public String toString() {
        return  orderId + "\t" + userId + "\t" + foodId + "\t" + sl + "\t" + dcdate  + "\t" + subprice ;
    }
}
