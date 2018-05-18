package cn.AssassinG.scsycc.entitys.Home.action;

import cn.AssassinG.scsycc.entitys.Home.biz.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;
import javax.resource.spi.AuthenticationMechanism;

@Controller
public class HomeController {
    @Autowired
    private HomeServices homeServices;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
        homeServices.sayHello();
        return "home";
    }


    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String getHome2(ModelMap model) {
        return "home";
    }
}
