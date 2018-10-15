package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.common.utils.StringUtils;
import cn.AssassinG.scsycc.entitys.User.biz.UserService;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.Role;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import com.alibaba.fastjson.JSON;
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

import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)//测试页面
    public String toTest(ModelMap model){
        return "test/test";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)//注册页面
    public String toReg(ModelMap model){
        model.put("registe_info", "");
        return "user/register";
    }

    @RequestMapping(value = "/getVcode", method = RequestMethod.GET)//获取验证码
    @ResponseBody
    public JSONObject toReg(@RequestParam("phone") String phone){
        User user = userService.findUserByPhone(phone);
        String vcode = StringUtils.getRandomStr(6);
        if(user == null){
            User new_user = new User();
            new_user.setPhone(phone);
            new_user.setVcode(vcode);
            new_user.setVcodeTime(new Date());
            System.out.println(new_user);
            userService.create(new_user);
        }else{
            user.setVcode(vcode);
            user.setVcodeTime(new Date());
            System.out.println(user);
            userService.update(user);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);
        jsonObject.put("msg", "请求成功");
        JSONObject contentObject = new JSONObject();
        contentObject.put("vcode", vcode);
        jsonObject.put("data", contentObject);
        return jsonObject;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)//提交注册
    @ResponseBody
    public JSONObject doReg(User user){
        JSONObject jsonObject = new JSONObject();
        if(user.getUserName() == null || user.getUserName().isEmpty()){
            jsonObject.put("status", 0);
            jsonObject.put("msg", "请输入用户名");
            jsonObject.put("data", null);
            return jsonObject;
        }else{
            User user_uname = userService.findUserByUname(user.getUserName());
            if(user_uname != null){
                jsonObject.put("status", 0);
                jsonObject.put("msg", "用户名不可用");
                jsonObject.put("data", null);
                return jsonObject;
            }
        }
        if(user.getPassWord() == null || user.getPassWord().isEmpty()){
            jsonObject.put("status", 0);
            jsonObject.put("msg", "请输入密码");
            jsonObject.put("data", null);
            return jsonObject;
        }
        User p_user = userService.findUserByPhone(user.getPhone());
        if(p_user == null || (!p_user.getVcode().equals(user.getVcode()))){
            jsonObject.put("status", 0);
            jsonObject.put("msg", "验证码不正确");
            jsonObject.put("data", null);
            return jsonObject;
        }else{
            long vcodetime = p_user.getVcodeTime().getTime();
            long nowtime = System.currentTimeMillis();
            long dur = nowtime - vcodetime;
            if(dur > 1000*60*5){
                jsonObject.put("status", 0);
                jsonObject.put("msg", "验证码已过期");
                jsonObject.put("data", null);
                return jsonObject;
            }
            p_user.setUserName(user.getUserName());
            p_user.setPassWord(user.getPassWord());
            userService.update(p_user);
            jsonObject.put("status", 1);
            jsonObject.put("msg", "注册成功");
            jsonObject.put("data", null);
            return jsonObject;
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
//        User p_user = userService.findUserByUname(user.getUserName());
//        if(p_user == null){
//            model.put("login_info", "查无此用户");
//            return "user/login";
//        }
//        if(p_user.getPassWord().equals(user.getPassWord()))
//            return "redirect:/home";
//        else {
//            model.put("login_info", "密码错误");
//            return "user/login";
//        }
//    }
}
