package mvn_ssm_0415.src.main.java.org.hlx.service.impl;

import org.hlx.dao.UserinfoDao;
import org.hlx.pojo.Userinfo;
import org.hlx.service.UserinfoService;
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
public class UserinfoServiceImpl implements UserinfoService {

    //注入底层数据
    @Resource
    private UserinfoDao  userinfoDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Userinfo> all() {
        return userinfoDao.all();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Userinfo user) {
        return userinfoDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Userinfo user) {
        return userinfoDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(int id) {
        return userinfoDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Userinfo findById(int id) {
        return userinfoDao.findById(id);
    }
}
