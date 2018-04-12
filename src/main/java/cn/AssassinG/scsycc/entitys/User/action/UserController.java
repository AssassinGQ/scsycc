package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.entitys.User.biz.UserServices;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @RequestMapping(value = "/Reg", method = RequestMethod.GET)//注册页面
    public String toReg(ModelMap model){
//        model.put("hobbyList", new String[]{"Swim", "Run"});
        return "register";
    }

    @RequestMapping(value = "/Reg", method = RequestMethod.POST)//提交注册
    public String doReg(User user, ModelMap model){
        model.put("User", user);
        userServices.create(user);
        return "forward:/WEB-INF/user/show.jsp";
    }

    @RequestMapping(value="/Login", method = RequestMethod.GET)
    public String toLogin(ModelMap model){
        System.out.println("In UserController-toLogin");
        return "login";
    }

    @RequestMapping(value="/Login", method = RequestMethod.POST)
    public String doLogin(User user, ModelMap model){
        model.put("User", user);
        System.out.println("In UserController-doLogin, User,username="+user.getUsername());
        return "success";
    }


}
