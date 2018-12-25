package com.ruolin.controller;

import com.ruolin.respository.EquipRepository;
import com.ruolin.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private UserRepository userRepository;
    private EquipRepository equipRepository;

    //查询所有用户
//    @GetMapping
//    public ModelAndView list(String userModel, Object model) {
//        model.addAttribute("userList", userRepository.findAll());
//        return new ModelAndView("manager/adminUser","userModel",model);
//    }
//    //查询所有设备
//    @GetMapping
//    public ModelAndView list(Model equipList) {
//        equipList.addAttribute("equipList", equipRepository.findAll());
//        return new ModelAndView("manager/adminEquip", "equipModel",equipList);
//    }
}
