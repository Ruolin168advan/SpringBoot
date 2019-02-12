package com.ruolin.firstspring.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ruolin.firstspring.entity.Equipment;
import com.ruolin.firstspring.mapper.EquipmentMapper;
import com.ruolin.firstspring.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
@Resource
@RestController
@CrossOrigin
@RequestMapping(value = "/equip")
public class EquipmentController {
    @Autowired
    private IEquipmentService equipmentService;
    @Autowired
    private EquipmentMapper equipmentMapper;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)  //查询某一个设备
    public Object getEquip(@PathVariable Integer id){
        Equipment equipment = equipmentMapper.selectById(id);
        return equipment;
    }

    @RequestMapping(value="/all", method=RequestMethod.GET) //查询全部设备
    public Object getAllUser(){
        Wrapper<Equipment> wrapper = new EntityWrapper<>();
        wrapper.orderBy(Equipment.ID,true);
        List<Equipment> list =  equipmentMapper.selectList(wrapper);
        return list;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)  //添加设备
    public Object addEquip(@RequestBody Equipment equipment){
        return equipmentMapper.insert(equipment);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST) //删除设备
    public Object deleteuser(@RequestBody Equipment equipment){
        Integer id = equipment.getId();
        return equipmentService.deleteById(id);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Object updateUser(@RequestBody Equipment equipment){
        equipment.getId();
        int line = equipmentMapper.updateById(equipment);
        return line;
    }
}
