package com.ruolin.firstspring.web;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ruolin.firstspring.entity.User;
import com.ruolin.firstspring.mapper.UserMapper;
import com.ruolin.firstspring.service.IUserService;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Object login(@Valid @RequestBody User user){
        System.out.println(user);
        String uname = user.getUname();
        String upwd = user.getUpwd();
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(uname, upwd);
        try {
            subject.login(token);
            System.out.println(token);
            EntityWrapper<User> wrapper = new EntityWrapper<>();
            wrapper.where("uname="+"\'"+uname+"\'")
                    .and("upwd="+"\'"+upwd+"\'");
//            wrapper.eq("uname",uname).eq("upwd", upwd);
            User resuser = userService.selectOne(wrapper);
            return resuser;
        } catch (UnknownAccountException e) {
            return "用户不存在";
        } catch (IncorrectCredentialsException e){
            return "密码错误";
        } catch (Exception e) {
            return "failed login"+user;
        }
    }

    @RequestMapping(value="/all", method=RequestMethod.GET) //查询全部用户(非管理员)
    public Object getAllUser(){
        Wrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq(User.ROLEID, 2);
        wrapper.orderBy(User.ID,true);
        return userMapper.selectList(wrapper);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Object getUserByUname(@RequestBody User user) {
        EntityWrapper<User> qryWrapper = new EntityWrapper<>();
        qryWrapper.where("uname="+"\""+user.getUname()+"\"")
                .and("upwd="+"\""+user.getUpwd()+"\"");
        System.out.println(qryWrapper.getSqlSegment());
        User resuser = userService.selectOne(qryWrapper);
        return resuser;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)  //添加用户
    public Object addUser(@RequestBody User user){
        System.out.println(user);
        userMapper.insert(user);
        return user;
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST) //删除用户
    public Object deleteuser(@RequestBody User user){
        Integer id = user.getId();
        System.out.println(id);
        return userMapper.deleteById(id);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Object updateUser(@RequestBody User user){
         user.getId();
         userMapper.updateById(user);
        return user;
    }
}

