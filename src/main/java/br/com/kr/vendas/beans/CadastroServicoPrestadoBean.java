package br.com.kr.vendas.beans;

import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.exceptions.ServicoPrestadoException;
import br.com.kr.vendas.model.Cliente;
import br.com.kr.vendas.model.Produto;
import br.com.kr.vendas.model.Servico;
import br.com.kr.vendas.model.ServicoPrestado;
import br.com.kr.vendas.services.ClienteService;
import br.com.kr.vendas.services.ProdutoService;
import br.com.kr.vendas.services.ServicoPrestadoService;
import br.com.kr.vendas.services.ServicoService;
import br.com.kr.vendas.utils.FacesUtils;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CadastroServicoPrestadoBean implements Serializable {

    @Inject
    private ServicoService servicoService;

    @Inject
    private ClienteService clienteService;

    @Inject
    private ProdutoService produtoService;

    @Inject
    private ServicoPrestadoService servicoPrestadoService;

    private ServicoPrestado servicoPrestado = new ServicoPrestado();

    private List<Servico> servicos = new ArrayList<>();

    private List<Cliente> clientes = new ArrayList<>();

    private List<Produto> produtos = new ArrayList<>();

    @PostConstruct
    public void init(){
        populaListas();

    }

    public void populaListas(){
        servicos = servicoService.listAll();
        clientes = clienteService.listAll();
        produtos = produtoService.listAll();
    }

    public void limpaCache(){
        servicoPrestado = new ServicoPrestado();

    }

    public void calcularValorTotal(){

        if(!servicoPrestado.getServicos().isEmpty())
          servicoPrestado.setValorTotal(servicoPrestado.getServicos()
                  .stream()
                  .mapToDouble(servico -> servico.getValor())
                  .sum());

            if(!servicoPrestado.getProdutos().isEmpty()){
                servicoPrestado.setValorTotal(servicoPrestado.getValorTotal()
                        + servicoPrestado.getProdutos()
                        .stream()
                        .mapToDouble(produto -> produto.getValor())
                        .sum());
            }
    }

    public void atualizaEstoque(){
        for (Produto p: servicoPrestado.getProdutos()) {
            if(p.getEstoque() - 1 >= 0) {
                p.setEstoque(p.getEstoque() - 1);
                produtoService.update(p);
            }else{
                throw new ServicoPrestadoException("semEstoque");
            }
        }
    }

    @Transactional
    public void salvar(){
        try {
            if(servicoPrestado.getServicos().isEmpty() && servicoPrestado.getProdutos().isEmpty()) {
                throw new ServicoPrestadoException("servicoProdutoNull");
            }else{
                calcularValorTotal();
                servicoPrestadoService.save(servicoPrestado);
                atualizaEstoque();
                limpaCache();
                FacesUtils.addSuccessMessage("SalvoSucesso");
            }
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erroCadastroPrestacaoServico");
            throw e;
        }
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ServicoPrestado getServicoPrestado() {
        return servicoPrestado;
    }

    public void setServicoPrestado(ServicoPrestado servicoPrestado) {
        this.servicoPrestado = servicoPrestado;
    }
}
