package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.biz.UserService;
import cn.AssassinG.scsycc.entitys.User.dao.UserDao;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-content.xml"})
public class TestUser {
    private static Logger logger = Logger.getLogger(TestUser.class);
    //测试UserDao
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("duyanting");
        user.setPassword("d123456");
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
        logger.info("Inserted id: " + userDao.insert(user));
    }

    @Test
    public void testBatchInsert() {
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
        logger.info("Inserted : " + userDao.insert(users) + " items");
    }

    @Test
    public void testGetById() {
        logger.info(userDao.getById(1));
    }

    @Test
    public void testUpdate() {
        User user = userDao.getById(2);
        user.setUsername("updatedname2");
        logger.info("Updated " + userDao.update(user) + " items");
    }

    @Test
    public void testBatchUpdate() {
        User user2 = userDao.getById(2);
        User user3 = userDao.getById(3);
        user2.setUsername("updatedname2");
        user3.setUsername("updatedname3");
        List<User> users = new ArrayList<User>();
        users.add(user2);
        users.add(user3);
        logger.info("Updated " + userDao.update(users) + " items");
    }

    @Test
    public void testDelete() {
        User user = userDao.getById(1);
        logger.info("Deleted " + userDao.delete(user) + " items");
    }

    @Test
    public void testListAll() {
        List<User> users = userDao.listAll();
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        logger.info(userDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        List<User> users = userDao.listBy(paramMap);
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<User> pageBean = userDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<User> users = pageBean.getRecordList();
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    //测试UserService
    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        User user = new User();
        user.setUsername("duyanting");
        user.setPassword("123456");
        logger.info("Inserted id: " + userService.create(user));
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(1L);
    }

    @Test
    public void testFindUserById() {
        User user = new User();
        user.setUsername("duyanting");
        user.setPassword("123456");
        logger.info("Inserted id: " + userService.findUserById(1L));
    }

    @Test
    public void testFindUserByUname() {
        User user = new User();
        user.setUsername("duyanting");
        user.setPassword("123456");
        logger.info("Inserted id: " + userService.findUserByUname("superadmin"));
    }
}
