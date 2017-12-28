package com.cdsxt.dao.impl;

import com.cdsxt.dao.DeptDao;
import com.cdsxt.po.Dept;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    // 查询所有部门并返回
    @Override
    public List<Dept> queryAll() {
        Session session = this.getSession();
        Query query = session.createQuery("from Dept t");
        List<Dept> result = query.list();

        // session.close(); // session 会在事务打开的地方关闭
        return result;
    }

    @Override
    public void addDept(Dept dept) {
        Session session = this.getSession();
        session.save(dept);
    }
}
