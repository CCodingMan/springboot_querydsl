package com.ljj.springboot_querydsl.controller;


import com.ljj.springboot_querydsl.dao.GoodInfosJPA;
import com.ljj.springboot_querydsl.entity.GoodInfos;
import com.ljj.springboot_querydsl.entity.QGoodInfos;
import com.ljj.springboot_querydsl.util.Inquirer;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 商品信息表(GoodInfos)表控制层
 *
 * @author makejava
 * @since 2019-09-02 16:36:41
 */
@RestController
public class GoodInfosController {
    @Autowired
    private GoodInfosJPA goodInfosJPA;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/query")
    public List<GoodInfos> list(){
        QGoodInfos _good = QGoodInfos.goodInfos;
        JPAQuery<GoodInfos> jpaQuery = new JPAQuery<>(entityManager);

        return jpaQuery.select(_good).from(_good).where(_good.type.id.eq(Long.valueOf("1"))).fetch();
    }

    @GetMapping("/join")
    public List<GoodInfos> join(){
        QGoodInfos _good = QGoodInfos.goodInfos;
        BooleanExpression booleanExpression = _good.type.id.eq(Long.valueOf("1"));
        Iterator<GoodInfos> iterator = goodInfosJPA.findAll(booleanExpression).iterator();
        List<GoodInfos> goods = new ArrayList<>();
        while (iterator.hasNext()){
            goods.add(iterator.next());
        }
        return goods;
    }

    /**
     * spring data jpa 整合querydsl完成查询
     * @return
     */
    @GetMapping("/join2")
    public List<GoodInfos> join2(){
        QGoodInfos _good = QGoodInfos.goodInfos;
        Inquirer inquirer = new Inquirer();
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));

        return inquirer.iteratorToList(goodInfosJPA.findAll(inquirer.buildQuery()));
    }
}