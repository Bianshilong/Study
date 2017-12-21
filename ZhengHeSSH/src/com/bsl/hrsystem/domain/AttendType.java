package com.bsl.hrsystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/11/30.
 * 考勤类型的持久化类
 */
@Entity
@Table(name="attend_type_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Getter@Setter
public class AttendType implements Serializable {

    private static final long serialVersionUID = 48L;

    @Id@Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //标识属性

    @Column(name = "type_name",nullable = false,length = 50)
    private String name;            //出勤类型的名称

    @Column(name="amerce_amount",nullable = false)
    private double amerce;          //此类出勤对应的罚款

    //无参的构造函数
    public AttendType() {
    }

    //有参的构造函数
    public AttendType(Integer id, String name, double amerce) {
        this.id=id;
        this.name = name;
        this.amerce = amerce;
    }
}
