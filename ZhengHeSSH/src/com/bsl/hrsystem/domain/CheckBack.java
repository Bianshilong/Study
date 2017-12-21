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
@Table(name = "checkback_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter@Setter
public class CheckBack implements Serializable {

    private static final long serialVersionUID = 48L;

    @Id@Column(name = "check_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 //标识属性

    @Column(name = "check_result",nullable = false)
    private boolean result;             //是否同意申请

    @Column(name ="check_reason",length =255)
    private String reason;              //批复理由

    @OneToOne(targetEntity = Application.class)
    @JoinColumn(name = "app_id",nullable = false,unique = true)
    private Application app;            //该批复对应的申请

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "mgr_id",nullable = false)
    private Manager manager;            //批复的经理

    //无参的构造函数
    public CheckBack() {
    }

    //有参的构造函数
    public CheckBack(Integer id, boolean result, String reason, Application app, Manager manager) {
        this.id = id;
        this.result = result;
        this.reason = reason;
        this.app = app;
        this.manager = manager;
    }
}
