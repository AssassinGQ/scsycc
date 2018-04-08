package TestMyBatis;

import cn.AssassinG.scsycc.entitys.User.biz.UserInfoServices;
import cn.AssassinG.scsycc.entitys.User.entity.UserInfo;
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
        UserInfoServices userInfoServices = (UserInfoServices)ctx.getBean("Userservices");
        UserInfo userinfo = new UserInfo();
        userinfo.setNickName("duyanting");
        userinfo.setCreateTime(new Date());
        userinfo.setUpdateTime(new Date());
        logger.info("Inserted id: "+ userInfoServices.create(userinfo));
    }
}
