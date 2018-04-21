/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


/**
 *
 * @author filip
 */
public abstract class AbstractDAO<PK extends Serializable, T>{
    
    private final Class<T> persisClass;

    public AbstractDAO(Class<T> persisClass) {
        this.persisClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }
    
}
