package com.ruolin.firstspring.service;

import com.ruolin.firstspring.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
public interface IUserService extends IService<User> {
	User selectUserByUsername(String uname);

}
