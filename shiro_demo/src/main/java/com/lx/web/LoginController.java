package com.lx.web;

import com.lx.entity.User;
import com.lx.service.LoginService;
import com.lx.shiro.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(Model model) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("info", "请先登出");
            return "error";
        }
        return "login";
    }

    @RequestMapping("loginCheck")
    public String loginCheck(String username, String password, Model model) {
        if (username != null && !username.equals("")&&password != null && !password.equals("")) {
            //创建令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            //获取用户
            Subject subject = SecurityUtils.getSubject();
            //用令牌登录
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException ice) {
                model.addAttribute("info","密码错误");
                return "error";
            } catch (UnknownAccountException ua) {
                model.addAttribute("info","用户名错误");
                return "error";
            } catch (ExcessiveAttemptsException eae) {
                model.addAttribute("info","登录失败次数上限");
                return "error";
            }
            //放入session
            User u = loginService.findByUsername(username);
            subject.getSession().setAttribute("user",u);

        }
        return "error";
    }

    /**
     * 注册页面
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    /**
     * 权限页面
     */
    @RequestMapping(value = "unauthorized",method = RequestMethod.GET)
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 注册记录
     */
    @RequestMapping(value = "registerUser",method = RequestMethod.POST)
    public String registerUser(User user,Model model) {

        new PasswordHelper().encryptPassword(user);
        loginService.registerUser(user);
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        return "login";
    }

    /**
     * 登录查看
     */
    @RequestMapping("iflogin")
    public String iflogin(Model model) {
        //获取用户信息
        Subject subject = SecurityUtils.getSubject();
        Object user = subject.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "iflogin";
    }

    /**
     * amin权限登录
     * @param model
     * @return
     */
    @RequestMapping("admin")
    public String admin(Model model) {
        //获取用户信息
        Subject subject = SecurityUtils.getSubject();
        Object user = subject.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "admin";
    }
}
