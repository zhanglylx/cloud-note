package cn.zly.service;

import cn.zly.entity.User;
import cn.zly.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public interface UserService {

    NoteResult<User> checkLogin(String name, String password);

    NoteResult addUser(String name, String password, String nike);

}
