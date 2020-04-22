package javaoop_0227.src.home.lyx;

public class Phone {
    private String brand;
    private String type;

    public Phone(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Phone(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
