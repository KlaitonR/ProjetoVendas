package br.com.kr.vendas.DAO;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.Endereco;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class EnderecoDAO implements Serializable {

    @Inject
    private EntityManager em;

    private DAO<Endereco> dao;

    @PostConstruct
    void init(){
        this.dao = new DAO<Endereco>(Endereco.class, this.em);
    }

    public void save(Endereco entity) {
        dao.save(entity);
    }

    public void remove(Endereco entity) {
        dao.remove(entity);
    }

    public void update(Endereco entity) {
        dao.update(entity);
    }

    public List<Endereco> listAll() {
        return dao.listAll();
    }

    public Endereco findById(Integer id) {
        return dao.findById(id);
    }

    public List<Endereco> listAllMaxResults(int firstResult, int maxResults) {
        return dao.listAllMaxResults(firstResult, maxResults);
    }

    public int countEntitys() {
        return dao.countEntitys();
    }

}
