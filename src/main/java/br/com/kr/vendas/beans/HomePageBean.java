package br.com.kr.vendas.beans;

import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.model.*;
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
public class HomePageBean implements Serializable {

    @Inject
    private ProdutoService produtoService;

    @Inject
    private ServicoService servicoService;

    @Inject
    private ServicoPrestadoService servicoPrestadoService;

    private Usuario usuario;

    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Servico> servicos = new ArrayList<Servico>();
    private List<ServicoPrestado> servicosPrestados = new ArrayList<ServicoPrestado>();

    @PostConstruct
    public void init(){
        limparCache();
        produtos = produtoService.listAll();
        servicos = servicoService.listAll();
        servicosPrestados = servicoPrestadoService.listAll();
    }

    private void limparCache(){
        produtos.clear();
        servicos.clear();
        servicosPrestados.clear();
    }

    public void habilitarEdicacao(Produto produto){
        produto.setEditando(true);
    }

    public void habilitarEdicacaoServico(Servico servico){
        servico.setEditando(true);
    }

    @Transactional
    public void excluirProduto(Produto produto) throws Exception{
        try{
            produtos.remove(produto);
            produtoService.remove(produto);
            FacesUtils.addSuccessMessage("produtoDeletadoSucesso");
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
        }
    }

    @Transactional
    public void excluirServico(Servico servico) throws Exception{
        try{
            servicos.remove(servico);
            servicoService.remove(servico);
            FacesUtils.addSuccessMessage("servicoDeletadoSucesso");
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
        }
    }

    @Transactional
    public void editarProduto(Produto produto){
        try{
            produtoService.update(produto);
            produto.setEditando(false);
            FacesUtils.addSuccessMessage("produtoEditadoSucesso");
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
        }
    }

    @Transactional
    public void editarServico(Servico servico){
        try{
            servicoService.update(servico);
            servico.setEditando(false);
            FacesUtils.addSuccessMessage("servicoEditadoSucesso");
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
        }
    }

    @Transactional
    public void buscarTodosProdutos() throws Exception{
        try{
            produtos.clear();
            produtos = produtoService.listAll();
            FacesUtils.addSuccessMessage("sucesso");
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
            throw e;
        }
    }

//    public ForwardView acessarCadastroUsuario(){
//
//        if(!usuarioDAO.findByHQLQuery("searchUsers", Arrays.asList(usuario.getUsuario(), usuario.getSenha()),0).isEmpty()){
//            context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
//            return new ForwardView(new RedirectView("homePage").toString());
//        }
//
//        context.getExternalContext().getFlash().setKeepMessages(true);
//        FacesUtils.addErrorMessage("usuarioNaoEncontrado");
//
//        return new ForwardView(new RedirectView("login").toString());
//    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<ServicoPrestado> getServicosPrestados() {
        return servicosPrestados;
    }

    public void setServicosPrestados(List<ServicoPrestado> servicosPrestados) {
        this.servicosPrestados = servicosPrestados;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
