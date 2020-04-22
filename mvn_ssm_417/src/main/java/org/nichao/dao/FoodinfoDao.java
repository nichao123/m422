package org.nichao.dao;

import org.nichao.pojo.Foodinfo;

import java.util.List;

/**
 * 底层接口
 */
public interface FoodinfoDao {
    public List<Foodinfo> all();

    public int insert(Foodinfo food);

    public int update(Foodinfo food);

    public int delete(int id);

    public Foodinfo findById(int id);


    //根据条件查找
    public List<Foodinfo> findName(Foodinfo foodinfo);
}
