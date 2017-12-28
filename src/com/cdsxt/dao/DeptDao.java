package com.cdsxt.dao;

import com.cdsxt.po.Dept;

import java.util.List;

public interface DeptDao {

    List<Dept> queryAll();

    void addDept(Dept dept);
}
