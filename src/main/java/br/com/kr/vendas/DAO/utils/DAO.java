package br.com.kr.vendas.DAO.utils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class DAO<T> implements Serializable {

    private final Class<T> classe;
    private EntityManager em;

    public DAO(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;
    }

    public T save(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    public void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.flush();
    }

    public T update(T entity) {
        em.merge(entity);
        em.flush();
        return entity;
    }

    public T findById(Serializable id) {
        return em.find(this.classe, id);
    }

    public List<T> listAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Select e from ").append(this.classe.getSimpleName()).append(" e");
        TypedQuery<T> query = em.createQuery(sb.toString(), this.classe);
        return query.getResultList();
    }

    public List<T> listAllMaxResults(int firstResult, int maxResults) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select e from ").append(this.classe.getSimpleName()).append(" e");
        TypedQuery<T> query = em.createQuery(sb.toString(), this.classe);
        return query.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public int countEntitys() {
        long result = (Long) em.createQuery("select count(n) from " + classe.getSimpleName() + " n")
                .getSingleResult();

        return (int) result;
    }

}
