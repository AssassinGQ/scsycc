package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupUserDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupUserDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.UserGroup_User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-content.xml"})
public class TestUserGroupUser {
    private static Logger logger = Logger.getLogger(TestUserGroupUser.class);
    @Autowired
    private UserGroupUserDao usergroupuserDao;
    @Test
    public void testInsert(){
        UserGroup_User usergroupuser = new UserGroup_User();
        usergroupuser.setUserId(1L);
        usergroupuser.setUserGroupId(1L);
        usergroupuser.setCreateTime(new Date());
        usergroupuser.setUpdateTime(new Date());
        logger.info("Inserted id: "+usergroupuserDao.insert(usergroupuser));
    }

    @Test
    public void testBatchInsert(){
        UserGroup_User usergroupuser = new UserGroup_User();
        usergroupuser.setUserId(1L);
        usergroupuser.setUserGroupId(1L);
        usergroupuser.setCreateTime(new Date());
        usergroupuser.setUpdateTime(new Date());
        UserGroup_User usergroupuser2 = new UserGroup_User();
        usergroupuser.setUserId(2L);
        usergroupuser.setUserGroupId(2L);
        usergroupuser2.setCreateTime(new Date());
        usergroupuser2.setUpdateTime(new Date());
        List<UserGroup_User> usergroupusers = new ArrayList<UserGroup_User>();
        usergroupusers.add(usergroupuser);
        usergroupusers.add(usergroupuser2);
        logger.info("Inserted : "+usergroupuserDao.insert(usergroupusers)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(usergroupuserDao.getById(1));
    }

    @Test
    public void testUpdate(){
        UserGroup_User usergroupuser = usergroupuserDao.getById(2);
        usergroupuser.setUserId(11L);
        usergroupuser.setUserGroupId(11L);
        logger.info("Updated "+usergroupuserDao.update(usergroupuser)+" items");
    }

    @Test
    public void testBatchUpdate(){
        UserGroup_User usergroupuser2 = usergroupuserDao.getById(2);
        UserGroup_User usergroupuser3 = usergroupuserDao.getById(3);
        usergroupuser2.setUserId(22L);
        usergroupuser3.setUserGroupId(33L);
        List<UserGroup_User> usergroupusers = new ArrayList<UserGroup_User>();
        usergroupusers.add(usergroupuser2);
        usergroupusers.add(usergroupuser3);
        logger.info("Updated "+usergroupuserDao.update(usergroupusers)+" items");
    }

    @Test
    public void testDelete(){
        UserGroup_User usergroupuser = usergroupuserDao.getById(2);
        logger.info("Deleted "+usergroupuserDao.delete(usergroupuser)+" items");
    }

    @Test
    public void testListAll(){
        List<UserGroup_User> usergroupusers = usergroupuserDao.listAll();
        for(int i = 0; i < usergroupusers.size(); i++)
            logger.info("Item"+i+":"+usergroupusers.get(i));
    }

    @Test
    public void testGetBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", true);
        logger.info(usergroupuserDao.getBy(paramMap));
    }

    @Test
    public void testListBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", false);
        List<UserGroup_User> usergroupusers = usergroupuserDao.listBy(paramMap);
        for(int i = 0; i < usergroupusers.size(); i++)
            logger.info("Item"+i+":"+usergroupusers.get(i));
    }

    @Test
    public void testListPage(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<UserGroup_User> pageBean = usergroupuserDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<UserGroup_User> usergroupusers = pageBean.getRecordList();
        for(int i = 0; i < usergroupusers.size(); i++)
            logger.info("Item"+i+":"+usergroupusers.get(i));
    }
}
