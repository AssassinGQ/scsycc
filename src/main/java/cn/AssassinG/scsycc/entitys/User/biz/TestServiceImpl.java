package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.dao.TestDao;
import cn.AssassinG.scsycc.entitys.User.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public long create(Test test) {
        return testDao.insert(test);
    }

    @Override
    public boolean update(Test test) {
        int result = testDao.update(test);
        return result == 1;
    }

    @Override
    public void deleteUserById(long testId) {
        Test test = testDao.getById(testId);
        if (test != null) {
            testDao.delete(test.getId());
        }
    }

    @Override
    public Test findUserById(Long testId) {
        Test test = testDao.getById(testId);
        if(test == null || test.isDeleted())
            return null;
        else
            return test;
    }
}
