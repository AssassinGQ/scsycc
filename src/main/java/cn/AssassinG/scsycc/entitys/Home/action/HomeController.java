package cn.AssassinG.scsycc.entitys.Home.action;

import cn.AssassinG.scsycc.entitys.Home.biz.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeServices;

    @Secured("ROLE_MPAGE_HOME")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
        homeServices.sayHello();
        return "home";
    }

    @Secured("ROLE_MPAGE_HOME2")
    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String getHome2(ModelMap model) {
        return "home";
    }
}
