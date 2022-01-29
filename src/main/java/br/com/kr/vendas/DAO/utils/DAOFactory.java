package br.com.kr.vendas.DAO.utils;

import br.com.kr.vendas.DAO.utils.DAO;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class DAOFactory implements Serializable {

    @Inject
    private EntityManager em;

    @SuppressWarnings({"rawtypes, unchecked"})
    @Produces
    @Dependent
    public <T> DAO<T> createDAO(InjectionPoint point){
        ParameterizedType type = (ParameterizedType) point.getType();
        Class classe = (Class) type.getActualTypeArguments()[0];
        return new DAO(classe, em);
    }

}
