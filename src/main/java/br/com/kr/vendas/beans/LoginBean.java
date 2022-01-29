package br.com.kr.vendas.beans;

import br.com.kr.vendas.DAO.utils.DAO;
import br.com.kr.vendas.model.Usuario;
import br.com.kr.vendas.utils.FacesUtils;
import br.com.kr.vendas.utils.ForwardView;
import br.com.kr.vendas.utils.RedirectView;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private DAO<Usuario> usuarioDAO;

    private FacesContext context;

    private Usuario usuario = new Usuario();

    public ForwardView formLogin(){
        return new ForwardView(new RedirectView("login").toString());
    }

    public ForwardView login(){

//        if(!usuarioDAO.findByHQLQuery("searchUsers", Arrays.asList(usuario.getUsuario(), usuario.getSenha()),0).isEmpty()){
//            context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
//            return new ForwardView(new RedirectView("homePage").toString());
//        }

        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesUtils.addErrorMessage("usuarioNaoEncontrado");

        return new ForwardView(new RedirectView("login").toString());
    }

    public ForwardView deslogar(){
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        return new ForwardView(new RedirectView("login").toString());
    }

    public DAO<Usuario> getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(DAO<Usuario> usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
