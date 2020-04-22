package org.nichao.service;

import com.github.pagehelper.PageInfo;
import org.nichao.pojo.Parames;
import org.nichao.pojo.Foodinfo;

import java.util.List;

/**
 * 底层接口
 */
public interface FoodrinfoService {
    public List<Foodinfo> all();

    public int insert(Foodinfo food);

    public int update(Foodinfo food);

    public int delete(int id);

    public Foodinfo findById(int id);

    //分页
    public PageInfo<Foodinfo> getPageInfo(Parames parames);


    //分页根据条件查找
    public PageInfo<Foodinfo>  findName(Foodinfo foodinfo, Parames parames);
}
