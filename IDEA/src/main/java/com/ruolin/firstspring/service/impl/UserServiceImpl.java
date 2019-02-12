package com.ruolin.firstspring.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ruolin.firstspring.entity.User;
import com.ruolin.firstspring.mapper.UserMapper;
import com.ruolin.firstspring.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUsername(String uname){
        Wrapper<User> wrapper =  new EntityWrapper<>();
        wrapper.eq(User.UNAME, uname);
        List<User> selectList = userMapper.selectList(wrapper);
        if(selectList.size()>0){
            return selectList.get(0);
        }
        return null;
    }

}
