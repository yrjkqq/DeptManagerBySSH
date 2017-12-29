package com.cdsxt.po;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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

    @NotEmpty(message = "部门名称不能为空")
    @Length(min = 4, max = 14, message = "部门名称长度必须在 4~14 个字符之间")
    private String dname;

    @NotEmpty(message = "部门地址不能为空")
    @Length(min = 4, max = 13, message = "部门地址长度必须在 4~13 个字符之间")
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
