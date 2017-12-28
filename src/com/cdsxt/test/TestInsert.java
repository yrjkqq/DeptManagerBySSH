package com.cdsxt.test;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInsert {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\Java\\training\\DeptManager\\web\\META-INF\\spring\\applicationContext.xml");
        SessionFactory factory = context.getBean(SessionFactory.class);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        SQLQuery query = session.createSQLQuery("insert into dept(dname, loc) values(?, ?)");
        query.setString(0, "RESEARCH");
        query.setString(1, "DC");
        query.executeUpdate();
        tx.commit();
        session.close();

    }
}
