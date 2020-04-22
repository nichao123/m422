package Zrj326.src.main.java.dao;

import pojo.Foodorderinfo;

import java.util.List;

public interface FoodorderinfoDao {
    int addFoodorderinfo(Foodorderinfo foodorderinfo);
    int updateFoodorderinfo(Foodorderinfo foodorderinfo);
    int delFoodorderinfo(int orderId);
    Foodorderinfo getFoodorderinfo(int orderId);
}
