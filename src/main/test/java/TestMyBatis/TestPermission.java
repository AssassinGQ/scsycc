package TestMyBatis;

import cn.AssassinG.scsycc.entitys.User.dao.PermissionDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-content.xml"})
public class TestPermission {
    private static Logger logger = Logger.getLogger(TestPermission.class);

    //测试UserDao
    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void testFindByUserId() {
        logger.info(permissionDao.findByUserId(1L));
    }

    @Test
    public void testFindByUsername() {
        logger.info(permissionDao.findByUsername("superadmin"));
    }
}
