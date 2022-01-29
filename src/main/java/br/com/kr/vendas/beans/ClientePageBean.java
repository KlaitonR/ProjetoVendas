package br.com.kr.vendas.beans;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.model.Cliente;
import br.com.kr.vendas.model.Endereco;
import br.com.kr.vendas.services.ClienteService;
import br.com.kr.vendas.utils.FacesUtils;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ClientePageBean implements Serializable {

    @Inject
    private ClienteService clienteService;

    @Inject
    private DAO<Endereco> enderecoDAO;

    private Cliente cliente = new Cliente();

    private Endereco endereco = new Endereco();

    private String nome;

    private String cpf;

    private List<String> lista = new ArrayList<>();

    @Transactional
    public List<Cliente> buscaClientePorNome() {
        try{
            List<Cliente> clientes = new ArrayList<>();
//            clientes.stream().filter(c -> c.getNome().startsWith(cliente.getNome())).collect(Collectors.toList());
            clientes = clienteService.buscaClientePorNome(cliente.getNome());
            return clientes;
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
            throw e;
        }
    }

    @Transactional
    public void carregaView(){

        List<Cliente> clientesNovos = clienteService.buscaClientePorNome("kla");

        System.out.println(cliente);

    }


    public DAO<Endereco> getEnderecoDAO() {
        return enderecoDAO;
    }

    public void setEnderecoDAO(DAO<Endereco> enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
