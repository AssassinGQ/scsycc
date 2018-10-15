package cn.AssassinG.scsycc.entitys.User.action;

import cn.AssassinG.scsycc.entitys.User.biz.TestService;
import cn.AssassinG.scsycc.entitys.User.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/postip", method = RequestMethod.GET)
    @ResponseBody
    public String postIP(@RequestParam("ip") String ip){
        Test test = testService.findUserById(1L);
        if(test == null){
            Test newtest = new Test();
            newtest.setIP(ip);
            testService.create(newtest);
        }else{
            test.setIP(ip);
            testService.update(test);
        }
        return "success";
    }

    @RequestMapping(value = "/getip", method = RequestMethod.GET)
    @ResponseBody
    public String getIP(){
        Test test = testService.findUserById(1L);
        return test.toString();
    }
}
