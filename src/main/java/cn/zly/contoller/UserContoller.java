package cn.zly.contoller;

import cn.zly.service.UserService;

import javax.annotation.Resource;

abstract class UserContoller {
    @Resource(name = "userService")
    UserService userService;
}
