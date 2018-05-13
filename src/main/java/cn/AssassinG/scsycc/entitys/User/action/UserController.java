package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.entitys.User.biz.UserServices;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)//注册页面
    public String toReg(ModelMap model){
        model.put("registe_info", "");
        return "user/register";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)//提交注册
    public String doReg(User user, ModelMap model){
        model.put("User", user);
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            model.put("registe_info", "请输入用户名");
            return "user/register";
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            model.put("registe_info", "请输入密码");
            return "user/register";
        }
        User p_user = userServices.findUserByUname(user.getUsername());
        if(p_user == null){
            userServices.create(user);
            return "redirect:/user/Login";
        }else{
            model.put("registe_info", "重复的用户名");
            return "user/register";
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView toLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        logger.info("get login");
        ModelAndView model = new ModelAndView();
        if(error != null){
            model.addObject("login_info", "用户名或密码不正确!");
        }
        if(logout != null){
            model.addObject("login_info", "您已成功注销系统.");
        }
        model.setViewName("user/login");
        return model;
    }

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @RequestMapping(value="/Login", method = RequestMethod.POST)
//    public ModelAndView doLogin(
//            @RequestParam(defaultValue = "") String username,
//            @RequestParam(defaultValue = "") String password,
//            HttpServletRequest request){
//        logger.info("post login:" + username+":"+password);
//        username = username.trim();
//        ModelAndView model = new ModelAndView();
//        model.setViewName("user/login");
//        if(username == null || username.isEmpty() ||
//                password == null || password.isEmpty()) {
//            model.addObject("login_info", "请输入用户名和密码");
//            return model;
//        }
//
//        model.setViewName("home");
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//        try{
//            Authentication authentication = authenticationManager.authenticate(authenticationToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            HttpSession session = request.getSession();
//            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
//        }catch (AuthenticationException ex){
//            model.setViewName("user/login");
//            model.addObject("login_info", "用户名或密码不正确!");
//        }
//        return model;
//
//        model.put("User", user);
//        User p_user = userServices.findUserByUname(user.getUsername());
//        if(p_user == null){
//            model.put("login_info", "查无此用户");
//            return "user/login";
//        }
//        if(p_user.getPassword().equals(user.getPassword()))
//            return "redirect:/home";
//        else {
//            model.put("login_info", "密码错误");
//            return "user/login";
//        }
//    }


}
