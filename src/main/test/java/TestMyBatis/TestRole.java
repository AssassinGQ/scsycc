package TestMyBatis;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import cn.AssassinG.scsycc.entitys.User.dao.RoleDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.Role;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class TestRole {
    private static Logger logger = Logger.getLogger(TestRole.class);
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-mybatis.xml", "spring/beans/RoleServiceImpl.xml"});
    private RoleDaoImpl roleDao = (RoleDaoImpl)ctx.getBean("RoleDao");
    @Test
    public void testInsert(){
        Role role = new Role();
        role.setRoleName("sadasda");
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        logger.info("Inserted id: "+roleDao.insert(role));
    }

    @Test
    public void testBatchInsert(){
        Role role = new Role();
        role.setRoleName("duyanting3");
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        Role role2 = new Role();
        role2.setRoleName("duyanting4");
        role2.setCreateTime(new Date());
        role2.setUpdateTime(new Date());
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        roles.add(role2);
        logger.info("Inserted : "+roleDao.insert(roles)+" items");
    }

    @Test
    public void testGetById(){
        logger.info(roleDao.getById(1));
    }

    @Test
    public void testUpdate(){
        Role role = roleDao.getById(2);
        role.setRoleName("updatedname2");
        logger.info("Updated "+roleDao.update(role)+" items");
    }

    @Test
    public void testBatchUpdate(){
        Role role2 = roleDao.getById(2);
        Role role3 = roleDao.getById(3);
        role2.setRoleName("updatedname2");
        role3.setRoleName("updatedname3");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role2);
        roles.add(role3);
        logger.info("Updated "+roleDao.update(roles)+" items");
    }

    @Test
    public void testDelete(){
        Role role = roleDao.getById(2);
        logger.info("Deleted "+roleDao.delete(role)+" items");
    }

    @Test
    public void testListAll(){
        List<Role> roles = roleDao.listAll();
        for(int i = 0; i < roles.size(); i++)
            logger.info("Item"+i+":"+roles.get(i));
    }

    @Test
    public void testGetBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", true);
        logger.info(roleDao.getBy(paramMap));
    }

    @Test
    public void testListBy(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageFirst", 2);
        paramMap.put("pageSize", 2);
        paramMap.put("isDeleted", false);
        List<Role> roles = roleDao.listBy(paramMap);
        for(int i = 0; i < roles.size(); i++)
            logger.info("Item"+i+":"+roles.get(i));
    }

    @Test
    public void testListPage(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Role> pageBean = roleDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Role> roles = pageBean.getRecordList();
        for(int i = 0; i < roles.size(); i++)
            logger.info("Item"+i+":"+roles.get(i));
    }
}
