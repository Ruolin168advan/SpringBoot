package com.ruolin.firstspring.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruolin.firstspring.entity.Equipuser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@Mapper
public interface EquipuserMapper extends BaseMapper<Equipuser> {

}