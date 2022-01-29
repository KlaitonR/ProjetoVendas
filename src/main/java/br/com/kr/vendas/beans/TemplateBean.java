package br.com.kr.vendas.beans;

import br.com.kr.vendas.utils.ForwardView;
import br.com.kr.vendas.utils.RedirectView;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class TemplateBean implements Serializable {

    public ForwardView redirectHomePage(){
        return new ForwardView(new RedirectView("homePage").toString());
    }

    public ForwardView redirectCadastroProduto(){
        return new ForwardView(new RedirectView("cadastroProduto").toString());
    }

    public ForwardView redirectCadastroServico(){
        return new ForwardView(new RedirectView("cadastroServico").toString());
    }

    public ForwardView redirectCadastroServicoPrestado(){
        return new ForwardView(new RedirectView("cadastroServicoPrestado").toString());
    }

    public ForwardView redirectCadastroCliente(){
        return new ForwardView(new RedirectView("cadastroCliente").toString());
    }

    public ForwardView redirectClientePage(){
        return new ForwardView(new RedirectView("clientePage").toString());
    }

}
