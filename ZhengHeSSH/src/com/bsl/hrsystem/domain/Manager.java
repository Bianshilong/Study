package com.bsl.hrsystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/11/30.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorValue(value = "2")
@Getter@Setter
public class Manager extends Employee implements Serializable {

    private static final long serialVersionUID = 48L;

    @Column(name = "dept_name",length = 50)
    private String dept;                    //该经理管理的部门

    //该经理对应的所有员工
    @OneToMany(targetEntity = Employee.class,mappedBy = "manager")
    private Set<Employee> employees = new HashSet<>();

    //该经理签署的所有批复
    @OneToMany(targetEntity = CheckBack.class,mappedBy = "manager")
    private Set<CheckBack> checks = new HashSet<>();

    //无参的构造函数
    public Manager() {
    }

    //有参的构造函数

    public Manager(String dept, Set<Employee> employees, Set<CheckBack> checks) {
        this.dept = dept;
        this.employees = employees;
        this.checks = checks;
    }
}
