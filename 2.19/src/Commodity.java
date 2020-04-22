import java.io.Serializable;

//商品类
public class Commodity implements Serializable {
    private String Commodityid;//编号
    private String Commodityname;//名称
    private int Commoditycount;//数量
    private double Commodityprice;//单价

    public Commodity() {
    }

    public Commodity(String commodityid, String commodityname, int commoditycount, double commodityprice) {
        Commodityid = commodityid;
        Commodityname = commodityname;
        Commoditycount = commoditycount;
        Commodityprice = commodityprice;
    }

    public String getCommodityid() {
        return Commodityid;
    }

    public void setCommodityid(String commodityid) {
        Commodityid = commodityid;
    }

    public String getCommodityname() {
        return Commodityname;
    }

    public void setCommodityname(String commodityname) {
        Commodityname = commodityname;
    }

    public int getCommoditycount() {
        return Commoditycount;
    }

    public void setCommoditycount(int commoditycount) {
        Commoditycount = commoditycount;
    }

    public double getCommodityprice() {
        return Commodityprice;
    }

    public void setCommodityprice(double commodityprice) {
        Commodityprice = commodityprice;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "Commodityid=" + Commodityid +
                ", Commodityname='" + Commodityname + '\'' +
                ", Commoditycount=" + Commoditycount +
                ", Commodityprice=" + Commodityprice +
                '}';
    }
}
