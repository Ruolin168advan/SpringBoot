package com.ruolin.firstspring.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruolin.firstspring.entity.Equipment;
import com.ruolin.firstspring.entity.Equipuser;
import com.ruolin.firstspring.mapper.EquipmentMapper;
import com.ruolin.firstspring.mapper.EquipuserMapper;
import com.ruolin.firstspring.service.IEquipuserService;
import com.ruolin.firstspring.service.impl.EquipuserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@RestController
@RequestMapping(value="/equipuser")
public class EquipuserController {
    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    EquipuserMapper equipuserMapper;

	@RequestMapping(value="/getequip",method= RequestMethod.GET)
    public Object showEquipByUser(Integer id){
	    System.out.println(id);
        Map<String,Object> columnMap = new HashMap<String, Object>();
        columnMap.put("user_id",id);
        List<Equipuser> list = equipuserMapper.selectByMap(columnMap);
        List<Equipment> equipments = new ArrayList<>();
        for (Equipuser equipuser : list) {
            Integer eid = equipuser.getEquipId();
            Equipment equipment = equipmentMapper.selectById(eid);
            equipments.add(equipment);
        }
        return equipments;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public Object getUserByUname(Integer uid) {
        System.out.println(uid);
        EntityWrapper<Equipuser> wrapper = new EntityWrapper<Equipuser>();
        wrapper.eq("user_id", uid);
        List<Equipuser> list =equipuserMapper.selectList(wrapper);
        return list;
    }
//    @RequiresRoles("admin")
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public Object addEquipToUser(@RequestBody Equipuser equipuser){
	    equipuserMapper.insert(equipuser);
	    return true;
    }

//    @RequiresRoles("admin")
    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public Object deleteEquipWithUser(@RequestBody Equipuser equipuser){
        System.out.println(equipuser);
	    Integer user_id = equipuser.getUserId();
	    Integer equip_id = equipuser.getEquipId();
        EntityWrapper<Equipuser> wrapper = new EntityWrapper<Equipuser>();
        wrapper.eq("user_id", user_id);
        wrapper.eq("equip_id", equip_id);
        int lines = equipuserMapper.delete(wrapper);
        return true;
    }
}
