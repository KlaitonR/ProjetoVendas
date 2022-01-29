package br.com.kr.vendas.DAO;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.Cliente;
import br.com.kr.vendas.model.Endereco;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class ClienteDAO implements Serializable {

    @Inject
    private EntityManager em;

    private DAO<Cliente> dao;

    @PostConstruct
    void init(){
        this.dao = new DAO<Cliente>(Cliente.class, this.em);
    }

    public void save(Cliente entity) {
        dao.save(entity);
    }

    public void remove(Cliente entity) {
        dao.remove(entity);
    }

    public void update(Cliente entity) {
        dao.update(entity);
    }

    public List<Cliente> listAll() {
        return dao.listAll();
    }

    public Cliente findById(Integer id) {
        return dao.findById(id);
    }

    public List<Cliente> listAllMaxResults(int firstResult, int maxResults) {
        return dao.listAllMaxResults(firstResult, maxResults);
    }

    public int countEntitys() {
        return dao.countEntitys();
    }

    public List<Cliente> buscaClientePorNome(String nome) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select c from ").append(Cliente.class.getSimpleName()).append(" c ");
        sb.append("where nome like '%").append(nome).append("%'");
        TypedQuery<Cliente> query = em.createQuery(sb.toString(), Cliente.class);
        return query.getResultList();
    }

    public List<Cliente> buscaClientePorCPF(Long cpf) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select c from ").append(Cliente.class.getSimpleName()).append(" c ");
        sb.append("where cpf = ").append(cpf);
        TypedQuery<Cliente> query = em.createQuery(sb.toString(), Cliente.class);
        return query.getResultList();
    }

    public List<Cliente> buscaClientePorEmail(String email){
        StringBuilder sb = new StringBuilder();
        sb.append("Select c from ").append(Cliente.class.getSimpleName()).append(" c ");
        sb.append("where email = '").append(email).append("'");
        TypedQuery<Cliente> query = em.createQuery(sb.toString(), Cliente.class);
        return query.getResultList();
    }

    public Endereco buscaEndereByIdCliente(Integer id){
        StringBuilder sb = new StringBuilder();
        sb.append("Select e from ").append(Cliente.class.getSimpleName()).append(" c ");
        sb.append("inner join ").append(Endereco.class.getSimpleName()).append("  e ");
        sb.append("on c.id_endereco = e.id ");
        sb.append("where c.id = ").append(id);
        TypedQuery<Endereco> query = em.createQuery(sb.toString(), Endereco.class);
        return query.getSingleResult();
    }

}
