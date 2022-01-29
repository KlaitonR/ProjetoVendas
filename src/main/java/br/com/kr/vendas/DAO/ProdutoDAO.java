package br.com.kr.vendas.DAO;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.Produto;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class ProdutoDAO implements Serializable {

    @Inject
    private EntityManager em;

    private DAO<Produto> dao;

    @PostConstruct
    void init(){
        this.dao = new DAO<Produto>(Produto.class, this.em);
    }

    public void save(Produto entity) {
        dao.save(entity);
    }

    public void remove(Produto entity) {
        dao.remove(entity);
    }

    public void update(Produto entity) {
        dao.update(entity);
    }

    public List<Produto> listAll() {
        return dao.listAll();
    }

    public Produto findById(Integer id) {
        return dao.findById(id);
    }

    public List<Produto> listAllMaxResults(int firstResult, int maxResults) {
        return dao.listAllMaxResults(firstResult, maxResults);
    }

    public int countEntitys() {
        return dao.countEntitys();
    }

}
