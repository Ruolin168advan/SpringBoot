package com.ruolin.firstspring.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruolin.firstspring.entity.User;
import com.ruolin.firstspring.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruolin
 * @since 2019-01-28
 */
@RestController
@CrossOrigin
@ResponseBody
public class PermissionController {
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//    public String login(String uname,String upwd){
//        System.out.println(uname+upwd);
    public Object login(@Valid @RequestBody User user){
        System.out.println(user);
        String uname = user.getUname();
        String upwd = user.getUpwd();
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(uname, upwd);
        try {
            subject.login(token);
            System.out.println(token);
            EntityWrapper<User> qryWrapper = new EntityWrapper<>();
            qryWrapper.where("uname="+"\""+user.getUname()+"\"")
                    .and("upwd="+"\""+user.getUpwd()+"\"");
//            qryWrapper.where("uname="+"\""+uname+"\"")
//                    .and("upwd="+"\""+upwd+"\"");
            User resuser = userService.selectOne(qryWrapper);

            return resuser;
//            return "success";
        } catch (UnknownAccountException e) {
            return "用户不存在";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }
    }

}
