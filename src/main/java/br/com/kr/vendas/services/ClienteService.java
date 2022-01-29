package br.com.kr.vendas.services;

import br.com.kr.vendas.DAO.ClienteDAO;
import br.com.kr.vendas.model.Cliente;
import br.com.kr.vendas.model.Endereco;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class ClienteService implements Serializable {

    @Inject
    private ClienteDAO dao;

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

    public List<Cliente> buscaClientePorNome(String nome){
       return dao.buscaClientePorNome(nome);
    }

    public List<Cliente> buscaClientePorCpf(Long cpf){
        return dao.buscaClientePorCPF(cpf);
    }

    public List<Cliente> buscaClientePorEmail(String email){
        return dao.buscaClientePorEmail(email);
    }

    public Endereco buscaEnderecoCliente(Integer id){
        return dao.buscaEndereByIdCliente(id);
    }

}
