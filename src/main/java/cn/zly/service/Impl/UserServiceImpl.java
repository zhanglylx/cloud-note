package cn.zly.service.Impl;

import cn.zly.dao.UserDaoMapper;
import cn.zly.entity.User;
import cn.zly.service.UserService;
import cn.zly.util.NoteResult;
import cn.zly.util.NoteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDaoMapper userDao;
    private final String produces = "applicaton/json;charset=utf-8";

    @Override
    public NoteResult<User> checkLogin(String name, String password) {
        //接收结果数据
        NoteResult<User> result = new NoteResult<>();
        //按参数name查询数据库
        try {
            User user = userDao.findByName(name);
            if (user == null) {
                result.setStatus(1);
                result.setMsg("用户不存在");
                return result;
            }
            if (!user.getCn_user_password().equals(password)) {
                result.setStatus(2);
                result.setMsg("密码不正确");
                return result;
            }

            //用户名和密码正确
            result.setStatus(0);
            result.setMsg("登录成功");
            result.setData(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(2);
            result.setMsg("服务端异常");
        }
        return result;
    }

    @Override
    public NoteResult addUser(String name, String password, String nike) {
        NoteResult noteResult = new NoteResult();
        noteResult.setStatus(2);
//        参数合法性检查
        if (StringUtils.isBlank(name)) {
            noteResult.setMsg("name为空");
            return noteResult;
        }
        if (StringUtils.isBlank(password)) {
            noteResult.setMsg("password为空");
            return noteResult;
        }
        if (StringUtils.isBlank(nike)) {
            noteResult.setMsg("nike为空");
            return noteResult;
        }
//        用户检查
        if (userDao.findByName(name) != null) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户名已存在");
            return noteResult;
        }
//        生成新用户
        User user = new User();
        user.setCn_user_id(NoteUtil.createId());
        user.setCn_user_name(name);
        user.setCn_user_password(password);
        user.setCn_user_nick(nike);
        userDao.save(user);
//        构建成功返回数据
        noteResult.setStatus(0);
        noteResult.setMsg("注册成功");
        return noteResult;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Base64Utils.encodeToString("++++////章fdsfsa".getBytes()));
        System.out.println(new BASE64Encoder().encode("++++////章fdsfsa dsaf打发第三方三房阿斯顿发大水发打发大水发大厦范德萨范德萨范德萨范德萨范德萨范德萨发大水发大厦范德萨".getBytes()));
        System.out.println(Base64.getEncoder().encodeToString("章".getBytes("gbk")));
        System.out.println(new String(Base64.getDecoder().decode("1cI=")));


    }
}
