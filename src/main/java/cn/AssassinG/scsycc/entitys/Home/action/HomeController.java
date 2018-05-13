package cn.AssassinG.scsycc.entitys.Home.action;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Secured("ROLE_PAGE_HOME")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
        return "home";
    }

    @Secured("ROLE_PAGE_HOME2")
    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String getHome2(ModelMap model) {
        return "home";
    }
}
