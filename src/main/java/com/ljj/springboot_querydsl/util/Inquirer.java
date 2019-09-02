package com.ljj.springboot_querydsl.util;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/9/2 18:35
 * @Description: 自定义查询实体类
 */
public class Inquirer {
    private List<BooleanExpression> booleanExpressions;

    public Inquirer() {
        this.booleanExpressions = new ArrayList<>();
    }

    /**
     * 添加查询条件到Query内的查询集合内
     * @param booleanExpression 查询条件继承BooleanExpression抽象对象的具体实体对象,querydsl已经封装
     * @return
     */
    public Inquirer putExpression(BooleanExpression booleanExpression){
        booleanExpressions.add(booleanExpression);
        return this;
    }

    /**
     * 构建出查询findAll函数使用的Predicate接口查询对象<br>
     * 调用buidleQuery()可直接作为findAll参数查询条件使用
     */
    public Predicate buildQuery(){
        BooleanExpression booleanExpression = null;
        for (int i = 0; i < booleanExpressions.size(); i++){
            if (i == 0){
                booleanExpression = booleanExpressions.get(i);
            }else {
                booleanExpression = booleanExpression.and(booleanExpressions.get(i));
            }
        }
        return booleanExpression;
    }

    /**
     * 将Iterable集合转换成ArrayList集合
     * @param iterable 源集合
     * @param <T> 类型
     * @return arrayList结果
     */
    public <T> List<T> iteratorToList(Iterable<T> iterable){
        List<T> returnList = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()){
            returnList.add(iterator.next());
        }
        return returnList;
    }
}
