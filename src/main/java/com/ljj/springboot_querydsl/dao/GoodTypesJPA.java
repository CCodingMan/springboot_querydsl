package com.ljj.springboot_querydsl.dao;


import com.ljj.springboot_querydsl.entity.GoodInfos;
import com.ljj.springboot_querydsl.entity.GoodTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * 商品类型(GoodTypes)表数据库访问层
 *
 * @author makejava
 * @since 2019-09-02 16:43:51
 */
public interface GoodTypesJPA extends JpaRepository<GoodTypes, Long>, QuerydslPredicateExecutor<GoodTypes> {

}