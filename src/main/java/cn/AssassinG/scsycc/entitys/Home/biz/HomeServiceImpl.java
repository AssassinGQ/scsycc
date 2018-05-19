package cn.AssassinG.scsycc.entitys.Home.biz;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Secured("ROLE_METHOD_HELLO")
    public String sayHello(){
        return "Hello, I'm HomeServices";
    }
}
