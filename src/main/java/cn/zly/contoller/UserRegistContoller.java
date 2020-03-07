package cn.zly.contoller;

import cn.zly.service.UserService;
import cn.zly.util.NoteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserRegistContoller extends UserContoller {

    @RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public NoteResult addUser(@RequestParam(name = "name") String name
            , @RequestParam(name = "password") String password
            , @RequestParam(name = "nick") String nick) {
        System.out.println("name:" + name);
        System.out.println("password:" + password);
        System.out.println("nick:" + nick);
        return userService.addUser(name, password, nick);
    }
}
