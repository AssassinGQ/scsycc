package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.entitys.User.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/https/userinfo")
public class UserInfoController {
    @RequestMapping(value="/getOpenInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getOpenInfo(UserInfo userindfo, ModelMap model){
        System.out.println("In UserInfoController-getOpenInfo:"+userindfo);
        return "login";
    }
    //https://localhost:8443/https/userinfo/getOpenInfo
//    @RequestMapping(value="/Login", method = RequestMethod.GET)
//    public String toLogin(ModelMap model){
//        System.out.println("In UserController-toLogin");
//        return "login";
//    }
//
//    @RequestMapping(value="/Login", method = RequestMethod.POST)
//    public String doLogin(User user, ModelMap model){
//        model.put("User", user);
//        System.out.println("In UserController-doLogin, User,username="+user.getUsername());
//        return "success";
//    }
//
//    @RequestMapping(value = "/Reg", method = RequestMethod.GET)
//    public String toReg(ModelMap model){
//        model.put("hobbyList", new String[]{"Swim", "Run"});
//        System.out.println("In UserController-toReg");
//        return "register";
//    }
//
//    @RequestMapping(value = "/Reg", method = RequestMethod.POST)
//    public String doReg(User user, ModelMap model){
//        model.put("User", user);
//        System.out.println("In UserController-doReg, User,username="+user.getUsername());
//        return "forward:/WEB-INF/User/show.jsp";
//    }
}
