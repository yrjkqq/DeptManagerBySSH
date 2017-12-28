package com.cdsxt.web.controller;

import com.cdsxt.po.Dept;
import com.cdsxt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 查询出来所有部门, 并返回到页面显示
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("depts", deptService.queryAll());
        return "depts/index";
    }

    @RequestMapping(value = "addDept", method = RequestMethod.GET)
    public String addDept() {
        return "depts/addDept";
    }

    @RequestMapping(value = "addDept", method = RequestMethod.POST)
    public String addDept(Dept dept) {
        deptService.addDept(dept);
        return "redirect:/depts";
    }

}
