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
        model.put("registe_info", "");
        return "register";
    }

    @RequestMapping(value = "/Reg", method = RequestMethod.POST)//提交注册
    public String doReg(User user, ModelMap model){
        model.put("User", user);
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            model.put("registe_info", "请输入用户名");
            return "register";
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            model.put("registe_info", "请输入密码");
            return "register";
        }
        User p_user = userServices.findUserByUname(user.getUsername());
        if(p_user == null){
            userServices.create(user);
            return "redirect:/user/Login";
        }else{
            model.put("registe_info", "重复的用户名");
            return "register";
        }
    }

    @RequestMapping(value="/Login", method = RequestMethod.GET)
    public String toLogin(ModelMap model){
        model.put("login_info", "");
        return "login";
    }

    @RequestMapping(value="/Login", method = RequestMethod.POST)
    public String doLogin(User user, ModelMap model){
        model.put("User", user);
        User p_user = userServices.findUserByUname(user.getUsername());
        if(p_user == null){
            model.put("login_info", "查无此用户");
            return "login";
        }
        if(p_user.getPassword().equals(user.getPassword()))
            return "success";
        else {
            model.put("login_info", "密码错误");
            return "login";
        }
    }


}
