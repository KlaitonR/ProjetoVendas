package br.com.kr.vendas.DAO;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.Servico;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class ServicoDAO implements Serializable {

    @Inject
    private EntityManager em;

    private DAO<Servico> dao;

    @PostConstruct
    void init(){
        this.dao = new DAO<Servico>(Servico.class, this.em);
    }

    public void save(Servico entity) {
        dao.save(entity);
    }

    public void remove(Servico entity) {
        dao.remove(entity);
    }

    public void update(Servico entity) {
        dao.update(entity);
    }

    public List<Servico> listAll() {
        return dao.listAll();
    }

    public Servico findById(Integer id) {
        return dao.findById(id);
    }

    public List<Servico> listAllMaxResults(int firstResult, int maxResults) {
        return dao.listAllMaxResults(firstResult, maxResults);
    }

    public int countEntitys() {
        return dao.countEntitys();
    }

}
