package org.nichao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nichao.dao.FoodinfoDao;
import org.nichao.pojo.Foodinfo;
import org.nichao.pojo.Parames;
import org.nichao.service.FoodrinfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserinfoServiceImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/15
 * @Version V1.0
 * 业务层
 *
 */
@Service   //业务
@Transactional  //事务
public class FoodinfoServiceImpl implements FoodrinfoService {

    //注入底层数据
    @Resource
    private FoodinfoDao foodinfoDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Foodinfo> all() {
        return foodinfoDao.all();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Foodinfo food) {
        return foodinfoDao.insert(food);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Foodinfo food) {
        return foodinfoDao.update(food);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(int id) {
        return foodinfoDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Foodinfo findById(int id) {
        return foodinfoDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<Foodinfo> getPageInfo(Parames parames) {
        //1>开始进行分页
        PageHelper.startPage(parames.getPageCurrent(),parames.getPageSize());

        //2>调用底层方法
        List<Foodinfo> list = foodinfoDao.all();

        //3>分页包装
        PageInfo<Foodinfo> pageInfo =new PageInfo<>(list);


        return pageInfo;
    }

    @Override
    public PageInfo<Foodinfo> findName(Foodinfo foodinfo, Parames parames) {
        //1>开始进行分页
        PageHelper.startPage(parames.getPageCurrent(),parames.getPageSize());

        //2>调用底层方法
        List<Foodinfo> list = foodinfoDao.findName(foodinfo);

        //3>分页包装
        PageInfo<Foodinfo> pageInfo =new PageInfo<>(list);

        return pageInfo;
    }
}
