package com.cdsxt.service;

import com.cdsxt.po.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> queryAll();

    void addDept(Dept dept);
}
