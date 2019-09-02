package com.ljj.springboot_querydsl.entity;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

/**
 * 商品类型(GoodTypes)表实体类
 *
 * @author ljj
 * @since 2019-09-02 16:47:25
 */
@Data
@Builder
@Entity
@Table(name = "good_types")
public class GoodTypes {
    /**
     * 商品类型id
     */
    @Id
    @GeneratedValue
    @Column(name = "tgt_id")
    private Long id;

    /**
     * 商品类型名称
     */
    @Column(name = "tgt_name")
    private String name;

    @Column(name = "tgt_order")
    private Integer order;

    /**
     * 是否显示0不显示，1显示
     */
    @Column(name = "tgt_is_show")
    private Integer show;

    /**
     * 解决@Date和@Build一起使用时无法生成默认构造方法问题
     */
    @Tolerate
    public GoodTypes() {
    }
}