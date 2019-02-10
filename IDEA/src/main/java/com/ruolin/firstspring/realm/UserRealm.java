package com.ruolin.firstspring.realm;



import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ruolin.firstspring.entity.Permission;
import com.ruolin.firstspring.entity.Role;
import com.ruolin.firstspring.entity.User;
import com.ruolin.firstspring.mapper.PermissionMapper;
import com.ruolin.firstspring.mapper.RoleMapper;
import com.ruolin.firstspring.service.IPermissionService;
import com.ruolin.firstspring.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper perMapper;

    // 这里做权限控制
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String uname = (String) pc.getPrimaryPrincipal();
        //将当前用户的角色和权限复制进来
        User user = userService.selectUserByUsername(uname);
        Integer roleid = user.getRoleid();
        Role role = roleMapper.selectById(roleid);
        info.addRole(role.getRolename());

        Wrapper<Permission> wrapper = new EntityWrapper<>();
        wrapper.eq("roleid",role.getId());
        List<Permission> selectList = perMapper.selectList(wrapper);
        List<String> perlist = new ArrayList<>();
        selectList.forEach(per -> {
            perlist.add(per.getPername());
        });
        info.addStringPermissions(perlist);


        return info;
//        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
    // 这里做登录控制
        AuthenticationInfo info;
        String uname = (String) at.getPrincipal();
        User user = userService.selectUserByUsername(uname);
        if(user!=null){
            info = new SimpleAuthenticationInfo(uname,user.getUpwd(),"ruolin");
            return info;
        }
        return null;
    }
}

