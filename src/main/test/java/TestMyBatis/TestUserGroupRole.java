package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupRoleDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupRoleDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.UserGroup_Role;
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
public class TestUserGroupRole {
    private static Logger logger = Logger.getLogger(TestUserGroupRole.class);
    @Autowired
    private UserGroupRoleDao usergrouproleDao;
    @Test
    public void testInsert(){
        UserGroup_Role usergrouprole = new UserGroup_Role();
        usergrouprole.setRoleId(1L);
        usergrouprole.setUserGroupId(1L);
        usergrouprole.setCreateTime(new Date());
        usergrouprole.setUpdateTime(new Date());
        logger.info("Inserted id: "+usergrouproleDao.insert(usergrouprole));
    }

    @Test
    public void testBatchInsert(){
        UserGroup_Role usergrouprole = new UserGroup_Role();
        usergrouprole.setRoleId(1L);
        usergrouprole.setUserGroupId(1L);
        usergrouprole.setCreateTime(new Date());
        usergrouprole.setUpdateTime(new Date());
        UserGroup_Role usergrouprole2 = new UserGroup_Role();
        usergrouprole.setRoleId(2L);
        usergrouprole.setUserGroupId(2L);
        usergrouprole2.setCreateTime(new Date());
        usergrouprole2.setUpdateTime(new Date());
        List<UserGroup_Role> usergrouproles = new ArrayList<UserGroup_Role>();
        usergrouproles.add(usergrouprole);
        usergrouproles.add(usergrouprole2);
        logger.info("Inserted : "+usergrouproleDao.insert(usergrouproles)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(usergrouproleDao.getById(1));
    }

    @Test
    public void testUpdate(){
        UserGroup_Role usergrouprole = usergrouproleDao.getById(2);
        usergrouprole.setRoleId(11L);
        usergrouprole.setUserGroupId(11L);
        logger.info("Updated "+usergrouproleDao.update(usergrouprole)+" items");
    }

    @Test
    public void testBatchUpdate(){
        UserGroup_Role usergrouprole2 = usergrouproleDao.getById(2);
        UserGroup_Role usergrouprole3 = usergrouproleDao.getById(3);
        usergrouprole2.setRoleId(22L);
        usergrouprole3.setUserGroupId(33L);
        List<UserGroup_Role> usergrouproles = new ArrayList<UserGroup_Role>();
        usergrouproles.add(usergrouprole2);
        usergrouproles.add(usergrouprole3);
        logger.info("Updated "+usergrouproleDao.update(usergrouproles)+" items");
    }

    @Test
    public void testDelete(){
        UserGroup_Role usergrouprole = usergrouproleDao.getById(2);
        logger.info("Deleted "+usergrouproleDao.delete(usergrouprole)+" items");
    }

    @Test
    public void testListAll(){
        List<UserGroup_Role> usergrouproles = usergrouproleDao.listAll();
        for(int i = 0; i < usergrouproles.size(); i++)
            logger.info("Item"+i+":"+usergrouproles.get(i));
    }

    @Test
    public void testGetBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", true);
        logger.info(usergrouproleDao.getBy(paramMap));
    }

    @Test
    public void testListBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", false);
        List<UserGroup_Role> usergrouproles = usergrouproleDao.listBy(paramMap);
        for(int i = 0; i < usergrouproles.size(); i++)
            logger.info("Item"+i+":"+usergrouproles.get(i));
    }

    @Test
    public void testListPage(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<UserGroup_Role> pageBean = usergrouproleDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<UserGroup_Role> usergrouproles = pageBean.getRecordList();
        for(int i = 0; i < usergrouproles.size(); i++)
            logger.info("Item"+i+":"+usergrouproles.get(i));
    }
}
