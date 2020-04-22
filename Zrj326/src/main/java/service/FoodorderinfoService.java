package Zrj326.src.main.java.service;

import pojo.Foodorderinfo;

public interface FoodorderinfoService {
    int addFoodorderinfo(Foodorderinfo foodorderinfo);
    int updateFoodorderinfo(Foodorderinfo foodorderinfo);
    int delFoodorderinfo(int orderId);
    Foodorderinfo getFoodorderinfo(int orderId);
}
