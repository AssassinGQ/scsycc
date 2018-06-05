package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.entitys.User.biz.UserService;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)//注册页面
    public String toReg(ModelMap model){
        model.put("registe_info", "");
        return "user/register";
    }

    @RequestMapping(value = "/authconfig", method = RequestMethod.GET)
    public String toAuthConfig(ModelMap model){
        return "auth/AuthConfig";
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
        User p_user = userService.findUserByUname(user.getUsername());
        if(p_user == null){
            userService.create(user);
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

    @RequestMapping(value="/authconfig/getAllPermission", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllPermission(){
        List<Permission> permissions = userService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);
        jsonObject.put("msg", "请求成功");
        JSONArray jsonArray = new JSONArray();
        for(Permission permission : permissions){
            jsonArray.add(permission.getPermissionName());
        }
        jsonObject.put("data", jsonArray);
        return jsonObject;
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
//        User p_user = userService.findUserByUname(user.getUsername());
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
