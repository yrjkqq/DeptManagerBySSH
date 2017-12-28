package com.cdsxt.service.impl;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> queryAllEmpByDeptno(Integer deptno) {
        return empDao.queryAllEmpByDeptno(deptno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }
}
