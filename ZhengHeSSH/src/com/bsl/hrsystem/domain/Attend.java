package com.bsl.hrsystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/11/30.
 */
@Entity
@Table(name="attend_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter@Setter
public class Attend implements Serializable {

    private static final long serialVersionUID = 48L;

    @Id@Column(name="attend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //代表标识属性

    @Column(name="duty_day",nullable = false,length = 50)
    private String dutyDay;         //出勤时间

    @Column(name = "punch_time")
    private Date punchTime;         //打卡时间

    @Column(name = "is_come",nullable = false)
    private boolean isCome;         //代表本次打卡是否为上班打卡

    @ManyToOne(targetEntity = AttendType.class)
    @JoinColumn(name="type_id",nullable = false)
    private AttendType type;        //本次出勤的类型

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "emp_id",nullable = false)
    private Employee employee;      //本次出勤关联的员工

    //无参的构造器
    public Attend() {
    }

    //有参的构造器
    public Attend(Integer id,String dutyDay, Date punchTime, boolean isCome, AttendType type, Employee employee) {
        this.id = id;
        this.dutyDay = dutyDay;
        this.punchTime = punchTime;
        this.isCome = isCome;
        this.type = type;
        this.employee = employee;
    }

    //根据employee,isCome,dutyDay来重写equals()和hashCode()方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attend attend = (Attend) o;

        if (isCome != attend.isCome) return false;
        if (dutyDay != null ? !dutyDay.equals(attend.dutyDay) : attend.dutyDay != null) return false;
        return employee != null ? employee.equals(attend.employee) : attend.employee == null;
    }

    @Override
    public int hashCode() {
        int result = dutyDay != null ? dutyDay.hashCode() : 0;
        result = 31 * result + (isCome ? 1 : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
