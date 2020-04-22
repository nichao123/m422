package Zrj326.src.main.java.service;

import pojo.Dianping;

public interface DianpingService {
    int addDianping(Dianping dianping);
    int updateDianping(Dianping dianping);
    int delDianping(int did);
    Dianping getDianping(int did);
}
