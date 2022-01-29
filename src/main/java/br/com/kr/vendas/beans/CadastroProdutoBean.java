package br.com.kr.vendas.beans;

import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.model.Produto;
import br.com.kr.vendas.services.ProdutoService;
import br.com.kr.vendas.utils.FacesUtils;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

    @Inject
    private ProdutoService produtoService;

    private Produto produto =  new Produto();

    @Transactional
    public void salvarProduto() throws Exception{
        try {
            System.out.println(produto);
            produtoService.save(produto);
            FacesUtils.addSuccessMessage("SalvoSucesso");
            produto = new Produto();
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
            throw e;
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
