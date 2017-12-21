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
@Table(name = "application_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter@Setter
public class Application implements Serializable {

    private static final long serialVersionUID = 48L;

    @Id@Column(name="app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 //代表标识属性

    @Column(name = "app_reason",length = 50)
    private String reason;              //申请理由

    @Column(name = "app_result")
    private boolean result;             //是否处理

    @ManyToOne(targetEntity = Attend.class)
    @JoinColumn(name = "attend_id",nullable = false)
    private Attend attend;              //关联的出勤记录

    @ManyToOne(targetEntity = AttendType.class)
    @JoinColumn(name = "type_id",nullable = false)
    private AttendType type;            //希望将指定出勤改为的type类型

    @OneToOne(targetEntity = CheckBack.class,mappedBy = "app")
    private CheckBack check;            //申请的结果

    //无参的构造函数
    public Application() {
    }

    //有参的构造函数

    public Application(Integer id,String reason, boolean result, Attend attend, AttendType type, CheckBack check) {
        this.id = id;
        this.reason = reason;
        this.result = result;
        this.attend = attend;
        this.type = type;
        this.check = check;
    }
}
