package Zrj326.src.main.java.service;

import pojo.Foodinfo;

import java.util.List;

public interface FoodinfoService {
    List<Foodinfo> all(String foodName);
    int addFoodinfo(Foodinfo foodinfo);
    int updateFoodinfo(Foodinfo foodinfo);
    int delFoodinfo(int foodId);
    Foodinfo getFoodinfo(int foodId);
}
