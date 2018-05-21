package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.dao.UserRoleDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserRoleDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.User_Role;
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
public class TestUserRole {
    private static Logger logger = Logger.getLogger(TestUserRole.class);
    @Autowired
    private UserRoleDao userroleDao;

    @Test
    public void testInsert(){
        User_Role userrole = new User_Role();
        userrole.setRoleId(1L);
        userrole.setUserId(1L);
        userrole.setCreateTime(new Date());
        userrole.setUpdateTime(new Date());
        logger.info("Inserted id: "+userroleDao.insert(userrole));
    }

    @Test
    public void testBatchInsert(){
        User_Role userrole = new User_Role();
        userrole.setRoleId(1L);
        userrole.setUserId(1L);
        userrole.setCreateTime(new Date());
        userrole.setUpdateTime(new Date());
        User_Role userrole2 = new User_Role();
        userrole.setRoleId(2L);
        userrole.setUserId(2L);
        userrole2.setCreateTime(new Date());
        userrole2.setUpdateTime(new Date());
        List<User_Role> userroles = new ArrayList<User_Role>();
        userroles.add(userrole);
        userroles.add(userrole2);
        logger.info("Inserted : "+userroleDao.insert(userroles)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(userroleDao.getById(1));
    }

    @Test
    public void testUpdate(){
        User_Role userrole = userroleDao.getById(2);
        userrole.setRoleId(11L);
        userrole.setUserId(11L);
        logger.info("Updated "+userroleDao.update(userrole)+" items");
    }

    @Test
    public void testBatchUpdate(){
        User_Role userrole2 = userroleDao.getById(2);
        User_Role userrole3 = userroleDao.getById(3);
        userrole2.setRoleId(22L);
        userrole3.setUserId(333L);
        List<User_Role> userroles = new ArrayList<User_Role>();
        userroles.add(userrole2);
        userroles.add(userrole3);
        logger.info("Updated "+userroleDao.update(userroles)+" items");
    }

    @Test
    public void testDelete(){
        User_Role userrole = userroleDao.getById(2);
        logger.info("Deleted "+userroleDao.delete(userrole)+" items");
    }

    @Test
    public void testListAll(){
        List<User_Role> userroles = userroleDao.listAll();
        for(int i = 0; i < userroles.size(); i++)
            logger.info("Item"+i+":"+userroles.get(i));
    }

    @Test
    public void testGetBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", true);
        logger.info(userroleDao.getBy(paramMap));
    }

    @Test
    public void testListBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", false);
        List<User_Role> userroles = userroleDao.listBy(paramMap);
        for(int i = 0; i < userroles.size(); i++)
            logger.info("Item"+i+":"+userroles.get(i));
    }

    @Test
    public void testListPage(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<User_Role> pageBean = userroleDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<User_Role> userroles = pageBean.getRecordList();
        for(int i = 0; i < userroles.size(); i++)
            logger.info("Item"+i+":"+userroles.get(i));
    }
}