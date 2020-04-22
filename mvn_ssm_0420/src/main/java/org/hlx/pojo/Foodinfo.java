package mvn_ssm_0420.src.main.java.org.hlx.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Foodinfo {
    private int foodId;
    private String foodName;
    private String remark;
    private double foodPrice;
    private String description;
    private String foodImage;


}
