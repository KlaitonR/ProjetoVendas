package br.com.kr.vendas.DAO;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.ServicoPrestado;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class ServicoPrestadoDAO implements Serializable {

    @Inject
    private EntityManager em;

    private DAO<ServicoPrestado> dao;

    @PostConstruct
    void init(){
        this.dao = new DAO<ServicoPrestado>(ServicoPrestado.class, this.em);
    }

    public void save(ServicoPrestado entity) {
        dao.save(entity);
    }

    public void remove(ServicoPrestado entity) {
        dao.remove(entity);
    }

    public void update(ServicoPrestado entity) {
        dao.update(entity);
    }

    public List<ServicoPrestado> listAll() {
        return dao.listAll();
    }

    public ServicoPrestado findById(Integer id) {
        return dao.findById(id);
    }

    public List<ServicoPrestado> listAllMaxResults(int firstResult, int maxResults) {
        return dao.listAllMaxResults(firstResult, maxResults);
    }

    public int countEntitys() {
        return dao.countEntitys();
    }

}
