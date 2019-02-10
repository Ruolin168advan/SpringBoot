package com.ruolin.firstspring.service.impl;

import com.ruolin.firstspring.entity.Role;
import com.ruolin.firstspring.mapper.RoleMapper;
import com.ruolin.firstspring.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
