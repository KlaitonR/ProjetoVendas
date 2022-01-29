package br.com.kr.vendas.services;

import br.com.kr.vendas.DAO.EnderecoDAO;
import br.com.kr.vendas.model.Endereco;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class EnderecoService implements Serializable {

    @Inject
    private EnderecoDAO dao;

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
