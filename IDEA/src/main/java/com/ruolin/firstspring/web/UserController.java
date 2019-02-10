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
    private UserMapper userMapper;

//    @RequiresPermissions("sys:search")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)  //查询
    public Object getUser(@PathVariable Integer id){
        return userService.selectById(id);
    }

//    @RequiresRoles("admin")
    @RequestMapping(value="/all", method=RequestMethod.GET) //查询全部用户(非管理员)
    public Object getAllUser(){
        Wrapper<User> wrapper = new EntityWrapper<>();
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

//    @RequiresRoles("admin")
    @RequestMapping(value="/add", method=RequestMethod.POST)  //添加用户
    public Object addUser(@RequestBody User user){
        System.out.println(user);
        userMapper.insert(user);
        return user;
    }

//    @RequiresPermissions("sys:delete")
    @RequestMapping(value="/delete", method=RequestMethod.POST) //删除用户
    public Object deleteuser(@RequestBody User user){
        Integer id = user.getId();
        System.out.println(id);
        return userMapper.deleteById(id);
    }

//    @RequiresRoles("admin")
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Object updateUser(@RequestBody User user){
         user.getId();
         userMapper.updateById(user);
        return user;
    }
}

