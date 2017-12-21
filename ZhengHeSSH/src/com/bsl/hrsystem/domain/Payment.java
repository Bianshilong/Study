package com.bsl.hrsystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/11/30.
 */
@Entity
@Table(name = "payment_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter@Setter
public class Payment implements Serializable {

    private static final long serialVersionUID = 48l;

    @Id@Column(name = "pay_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //标识属性

    @Column(name = "pay_month",nullable = false,length = 50)
    private String payMonth;        //发薪的月份

    @Column(name = "pay_amount",nullable = false)
    private double amount;          //发薪的数量

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "emp_id",nullable = false)
    private Employee employee;      //领薪的员工

    //无参的构造函数
    public Payment() {
    }

    //有参的构造函数

    public Payment(Integer id, String payMonth, double amount, Employee employee) {
        this.id = id;
        this.payMonth = payMonth;
        this.amount = amount;
        this.employee = employee;
    }
}
