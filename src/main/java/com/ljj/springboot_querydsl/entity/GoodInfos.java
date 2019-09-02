package com.ljj.springboot_querydsl.entity;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

/**
 * 商品信息表(GoodInfos)表实体类
 *
 * @author makejava
 * @since 2019-09-02 16:36:37
 */
@Data
@Builder
@Entity
@Table(name = "good_infos")
public class GoodInfos {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue
    @Column(name = "tg_Id")
    private Long id;
    /**
     * 商品名称
     */
    @Column(name = "tg_title")
    private String title;
    /**
     * 商品价格
     */
    @Column(name = "tg_price")
    private Double price;
    /**
     * 商品单位
     */
    @Column(name = "tg_unit")
    private String unit;

    @Column(name = "tg_order")
    private String order;

    @OneToOne
    @JoinColumn(name = "tg_type_id")
    private GoodTypes type;

    /**
     * 解决@Date和@Build一起使用时无法生成默认构造方法问题
     */
    @Tolerate
    public GoodInfos() {
    }
}