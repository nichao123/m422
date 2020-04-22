package Zrj326.src.main.java.dao;

import pojo.Foodinfo;

import java.util.List;

public interface FoodinfoDao {
    List<Foodinfo> all(String foodName);
    int addFoodinfo(Foodinfo foodinfo);
    int updateFoodinfo(Foodinfo foodinfo);
    int delFoodinfo(int foodId);
    Foodinfo getFoodinfo(int foodId);
}
