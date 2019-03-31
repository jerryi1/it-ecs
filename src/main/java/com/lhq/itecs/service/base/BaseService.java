package com.lhq.itecs.service.base;

import com.querydsl.core.BooleanBuilder;

import java.io.Serializable;
import java.util.Map;

public interface BaseService <Form,Entity,ID extends Serializable>{

    //根据id 获取数据
    Entity get(ID id);

    //根据id 删除数据
    void delete(ID id);

    //根据id,form 修改数据
    Entity update(ID id,Form form);


    //新增数据
    Entity add(Form form);


    //分页查询数据
    Map<String, Object> page(BooleanBuilder booleanBuilder, Integer page, Integer perPage);

}
