package mvn_ssm_0420.src.main.java.org.hlx.service.impl;

import org.hlx.dao.FoodInfoDao;
import org.hlx.pojo.Foodinfo;
import org.hlx.service.FoodInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName FoodInfoServiceImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/20
 * @Version V1.0
 **/
@Service
@Transactional
public class FoodInfoServiceImpl implements FoodInfoService {

    //注入底层数据
    @Resource
    private FoodInfoDao foodInfoDao;

    /**
     * 添加
     * @param food
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Foodinfo food) {
        return foodInfoDao.insert(food);
    }
}
