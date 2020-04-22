package Zrj326.src.main.java.pojo;

public class Dianping {
    private int did;
    private int foodId;
    private String kouwei;
    private String dpcontent;
    private int userId;
    private String dpdate;
    public Dianping() {
    }
    public Dianping(int did, int foodId, String kouwei, String dpcontent, int userId, String dpdate) {
        this.did = did;
        this.foodId = foodId;
        this.kouwei = kouwei;
        this.dpcontent = dpcontent;
        this.userId = userId;
        this.dpdate = dpdate;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public String getKouwei() {
        return kouwei;
    }
    public void setKouwei(String kouwei) {
        this.kouwei = kouwei;
    }
    public String getDpcontent() {
        return dpcontent;
    }
    public void setDpcontent(String dpcontent) {
        this.dpcontent = dpcontent;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getDpdate() {
        return dpdate;
    }
    public void setDpdate(String dpdate) {
        this.dpdate = dpdate;
    }
    @Override
    public String toString() {
        return did + "\t" + foodId + "\t" + kouwei + "\t" + dpcontent + "\t" + userId+ "\t" + dpdate ;
    }
}
