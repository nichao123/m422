package mvn_ssm_0415.src.main.java.org.hlx.service;

import org.hlx.pojo.Userinfo;

import java.util.List;

/**
 * 底层接口
 */
public interface UserinfoService {
    public List<Userinfo> all();

    public int insert(Userinfo user);

    public int update(Userinfo user);

    public int delete(int id);

    public Userinfo findById(int id);
}
