package TestMyBatis;

import cn.AssassinG.scsycc.entitys.User.biz.UserServices;
import cn.AssassinG.scsycc.entitys.User.dao.UserDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-mybatis.xml", "spring/beans/UserServiceImpl.xml"});
    private UserServices userServices = (UserServices)ctx.getBean("Userservices");
    private UserDaoImpl userDao = (UserDaoImpl)ctx.getBean("UserDao");
    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("duyanting");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        logger.info("Inserted id: "+userServices.create(user));
    }

    @Test
    public void testBatchInsert(){
        User user = new User();
        user.setUsername("duyanting3");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User user2 = new User();
        user2.setUsername("duyanting4");
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        logger.info("Inserted : "+userDao.insert(users)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(userDao.getById(1));
    }

    @Test
    public void testUpdate(){
        User user = userDao.getById(2);
        user.setUsername("updatedname2");
        logger.info("Updated "+userDao.update(user)+" items");
    }

    @Test
    public void testBatchUpdate(){
        User user2 = userDao.getById(2);
        User user3 = userDao.getById(3);
        user2.setUsername("updatedname2");
        user3.setUsername("updatedname3");
        List<User> users = new ArrayList<User>();
        users.add(user2);
        users.add(user3);
        logger.info("Updated "+userDao.update(users)+" items");
    }

    @Test
    public void testDelete(){
        User user = userDao.getById(1);
        logger.info("Deleted "+userDao.delete(user)+" items");
    }
}
