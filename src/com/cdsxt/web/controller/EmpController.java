package com.cdsxt.web.controller;

import com.cdsxt.po.Emp;
import com.cdsxt.service.DeptService;
import com.cdsxt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("findAllEmpByDeptno")
    @ResponseBody
    public List<Emp> queryAllEmpByDeptno(@RequestParam("deptno") Integer deptno) {
        return empService.queryAllEmpByDeptno(deptno);
    }

    // 添加员工
    @RequestMapping(value = "addEmp", method = RequestMethod.GET)
    public String addEmp(Model model) {
        // 需要所有部门, 然后将该员工添加到对应的部门中
        model.addAttribute("depts", deptService.queryAll());
        return "emps/addEmp";
    }

    // 验证参数
    @RequestMapping(value = "addEmp", method = RequestMethod.POST)
    public String addEmp(@Validated @ModelAttribute("returnEmp") Emp emp, BindingResult result) {
        if (result.hasErrors()) {
            return "emps/addEmp";
        }
        empService.addEmp(emp);
        return "redirect:/depts";
    }
}
