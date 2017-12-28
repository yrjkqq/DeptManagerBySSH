package com.cdsxt.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dept")
public class Dept {

    @Id
    @SequenceGenerator(name = "deptGen", sequenceName = "seq_dept")
    @GeneratedValue(generator = "deptGen")
    private Integer deptno;
    private String dname;
    private String loc;

    // 保存员工的集合
    @OneToMany(mappedBy = "dept")
    private Set<Emp> emps = new HashSet<>();

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
