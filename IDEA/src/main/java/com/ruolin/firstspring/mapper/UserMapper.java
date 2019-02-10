package com.ruolin.firstspring.mapper;

import com.ruolin.firstspring.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}