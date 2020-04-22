package Zrj326.src.main.java.dao;

import pojo.Dianping;

import java.util.List;

public interface DianpingDao {
    int addDianping(Dianping dianping);
    int updateDianping(Dianping dianping);
    int delDianping(int did);
    Dianping getDianping(int did);
}
