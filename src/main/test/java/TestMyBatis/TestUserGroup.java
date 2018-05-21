package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserGroupDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.UserGroup;
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
public class TestUserGroup {
    private static Logger logger = Logger.getLogger(TestUserGroup.class);
    @Autowired
    private UserGroupDao usergroupDao;
    @Test
    public void testInsert(){
        UserGroup usergroup = new UserGroup();
        usergroup.setUserGroupName("sadasda");
        usergroup.setCreateTime(new Date());
        usergroup.setUpdateTime(new Date());
        logger.info("Inserted id: "+usergroupDao.insert(usergroup));
    }

    @Test
    public void testBatchInsert(){
        UserGroup usergroup = new UserGroup();
        usergroup.setUserGroupName("duyanting3");
        usergroup.setCreateTime(new Date());
        usergroup.setUpdateTime(new Date());
        UserGroup usergroup2 = new UserGroup();
        usergroup2.setUserGroupName("duyanting4");
        usergroup2.setCreateTime(new Date());
        usergroup2.setUpdateTime(new Date());
        List<UserGroup> usergroups = new ArrayList<UserGroup>();
        usergroups.add(usergroup);
        usergroups.add(usergroup2);
        logger.info("Inserted : "+usergroupDao.insert(usergroups)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(usergroupDao.getById(1));
    }

    @Test
    public void testUpdate(){
        UserGroup usergroup = usergroupDao.getById(2);
        usergroup.setUserGroupName("updatedname2");
        logger.info("Updated "+usergroupDao.update(usergroup)+" items");
    }

    @Test
    public void testBatchUpdate(){
        UserGroup usergroup2 = usergroupDao.getById(2);
        UserGroup usergroup3 = usergroupDao.getById(3);
        usergroup2.setUserGroupName("updatedname2");
        usergroup3.setUserGroupName("updatedname3");
        List<UserGroup> usergroups = new ArrayList<UserGroup>();
        usergroups.add(usergroup2);
        usergroups.add(usergroup3);
        logger.info("Updated "+usergroupDao.update(usergroups)+" items");
    }

    @Test
    public void testDelete(){
        UserGroup usergroup = usergroupDao.getById(2);
        logger.info("Deleted "+usergroupDao.delete(usergroup)+" items");
    }

    @Test
    public void testListAll(){
        List<UserGroup> usergroups = usergroupDao.listAll();
        for(int i = 0; i < usergroups.size(); i++)
            logger.info("Item"+i+":"+usergroups.get(i));
    }

    @Test
    public void testGetBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", true);
        logger.info(usergroupDao.getBy(paramMap));
    }

    @Test
    public void testListBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", false);
        List<UserGroup> usergroups = usergroupDao.listBy(paramMap);
        for(int i = 0; i < usergroups.size(); i++)
            logger.info("Item"+i+":"+usergroups.get(i));
    }

    @Test
    public void testListPage(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<UserGroup> pageBean = usergroupDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<UserGroup> usergroups = pageBean.getRecordList();
        for(int i = 0; i < usergroups.size(); i++)
            logger.info("Item"+i+":"+usergroups.get(i));
    }
}
