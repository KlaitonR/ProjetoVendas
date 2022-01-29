package br.com.kr.vendas.services;

import br.com.kr.vendas.DAO.ServicoDAO;
import br.com.kr.vendas.model.Servico;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class ServicoService implements Serializable {

    @Inject
    private ServicoDAO dao;

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
