package cn.zly.contoller;

import cn.zly.entity.User;
import cn.zly.service.UserService;
import cn.zly.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.internet.ContentType;

@Controller
@RequestMapping("/user")
public class UserLoginContoller extends UserContoller {


    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public NoteResult<User> checkLogin(@RequestParam(name = "name") String name
            , @RequestParam(name = "password") String password) {
        System.out.println("name:" + name);
        System.out.println("password:" + password);
        return userService.checkLogin(name, password);
    }


}
