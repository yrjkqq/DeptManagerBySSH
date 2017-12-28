package com.cdsxt.dao.impl;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private SessionFactory sessionFactory;

    // 获取当前线程中的 Session 对象
    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    // 根据 deptno 查询, 查询指定部门所有员工
    @Override
    public List<Emp> queryAllEmpByDeptno(Integer deptno) {
        Session session = this.getSession();
        Query query = session.createQuery("from Emp e where e.dept.deptno = ?");
        query.setInteger(0, deptno);
        List<Emp> result = query.list();
        // session.close();
        return result;
    }

    @Override
    public void addEmp(Emp emp) {
        Session session = this.getSession();
        session.save(emp);
    }
}
