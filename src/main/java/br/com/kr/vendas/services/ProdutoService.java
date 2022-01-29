package br.com.kr.vendas.services;

import br.com.kr.vendas.DAO.ProdutoDAO;
import br.com.kr.vendas.model.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ProdutoService {

    @Inject
    private ProdutoDAO dao;

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
