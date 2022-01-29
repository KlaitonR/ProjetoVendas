package br.com.kr.vendas.services;

import br.com.kr.vendas.DAO.ServicoPrestadoDAO;
import br.com.kr.vendas.model.ServicoPrestado;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class ServicoPrestadoService implements Serializable {

    @Inject
    private ServicoPrestadoDAO dao;

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
