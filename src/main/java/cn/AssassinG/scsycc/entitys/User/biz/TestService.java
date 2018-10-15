package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.entity.Test;

public interface TestService {
    long create(Test test);
    boolean update(Test test);
    void deleteUserById(long testId);
    Test findUserById(Long testId);
}
