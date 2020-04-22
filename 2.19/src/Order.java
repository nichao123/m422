import java.io.Serializable;
import java.util.ArrayList;

//订单
public class Order implements Serializable {
    private String Orderid;//编号
    private ArrayList Commoditylist;//商品列表

    public Order() {
    }

    public Order(String orderid) {
        this.Orderid = orderid;
        this.Commoditylist=new ArrayList<Commodity>();
    }

    public String getOrderid() {
        return Orderid;
    }

    public void setOrderid(String orderid) {
        Orderid = orderid;
    }

    public ArrayList getCommoditylist() {
        return Commoditylist;
    }

    public void setCommoditylist(ArrayList commoditylist) {
        Commoditylist = commoditylist;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Orderid='" + Orderid + '\'' +
                ", Orderlist=" + Commoditylist +
                '}';
    }
}
