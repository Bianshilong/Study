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
 * Created by admin on 2017/11/29.
 * 创建持久化实例类Employee
 */
@Entity
@Table(name="employee_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorColumn(name = "emp_type",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "1")
@Getter@Setter
public class Employee implements Serializable{
    private static final long serialVersionUID = 48L;

    @Id@Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 //标识属性

    @Column(name = "emp_name",nullable = false,length = 50,unique = true)
    private String name;                //员工姓名

    @Column(name ="emp_pass",nullable = false,length = 50)
    private String pass;                //员工密码

    @Column(name = "emp_salary",nullable = false)
    private double salary;            //员工工资

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "mgr_id")
    private Manager manager;           //员工对应的经理

    @OneToMany(targetEntity = Attend.class,mappedBy = "employee")
    private Set<Attend> attends = new HashSet<>();          //员工对应的出勤记录

    @OneToMany(targetEntity = Payment.class,mappedBy = "employee")
    private Set<Payment> payments = new HashSet<>();        //员工对应的工资支付记录

    //无参的构造函数
    public Employee() {
    }

    //有参的构造函数

    public Employee(Integer id, String name, String pass, double salary, Manager manager, Set<Attend> attends, Set<Payment> payments) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.salary = salary;
        this.manager = manager;
        this.attends = attends;
        this.payments = payments;
    }

    //根据name和pass来重写equals()和hashCode()方法，只要name和pass相同，就认为相同

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return pass != null ? pass.equals(employee.pass) : employee.pass == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }
}
