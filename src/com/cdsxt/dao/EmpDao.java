package com.cdsxt.dao;

import com.cdsxt.po.Emp;

import java.util.List;

public interface EmpDao {

    List<Emp> queryAllEmpByDeptno(Integer deptno);

    void addEmp(Emp emp);
}
