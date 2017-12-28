package com.cdsxt.service;

import com.cdsxt.po.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> queryAllEmpByDeptno(Integer deptno);

    void addEmp(Emp emp);
}
