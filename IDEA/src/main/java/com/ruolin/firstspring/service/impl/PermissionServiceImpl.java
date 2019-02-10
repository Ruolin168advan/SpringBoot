package com.ruolin.firstspring.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ruolin.firstspring.entity.Permission;
import com.ruolin.firstspring.entity.Role;
import com.ruolin.firstspring.entity.User;
import com.ruolin.firstspring.mapper.PermissionMapper;
import com.ruolin.firstspring.mapper.RoleMapper;
import com.ruolin.firstspring.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ruolin.firstspring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ruolin
 * @since 2019-01-28
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {


}
