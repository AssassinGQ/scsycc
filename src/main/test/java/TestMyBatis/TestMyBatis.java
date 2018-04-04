package TestMyBatis;

import cn.AssassinG.scsycc.entitys.User.biz.UserServices;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-mybatis.xml", "spring/beans/UserServiceImpl.xml"});
        UserServices userServices = (UserServices)ctx.getBean("Userservices");
        User user = new User();
        user.setUsername("duyanting");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        logger.info("Inserted id: "+userServices.create(user));
    }
}
