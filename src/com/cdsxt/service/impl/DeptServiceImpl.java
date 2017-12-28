package com.cdsxt.service.impl;

import com.cdsxt.dao.DeptDao;
import com.cdsxt.po.Dept;
import com.cdsxt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }
}
