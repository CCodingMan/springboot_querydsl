package com.ljj.springboot_querydsl.dao;


import com.ljj.springboot_querydsl.entity.GoodInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * 商品信息表(GoodInfos)表数据库访问层
 *
 * @author makejava
 * @since 2019-09-02 16:36:38
 */
public interface GoodInfosJPA extends JpaRepository<GoodInfos, Long>, QuerydslPredicateExecutor<GoodInfos> {

}