package br.com.kr.vendas.beans;

import br.com.kr.vendas.anotation.Transactional;
import br.com.kr.vendas.model.Servico;
import br.com.kr.vendas.model.enums.TipoServicoEnum;
import br.com.kr.vendas.services.ServicoService;
import br.com.kr.vendas.utils.FacesUtils;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroServicoBean implements Serializable {

    @Inject
    private ServicoService servicoService;

    private Servico servico = new Servico();

    private TipoServicoEnum tipoServico;

    public TipoServicoEnum[] tipoServicoEnum (){
        return tipoServico.values();
    }

    public int countTipoServicos(){
        return tipoServico.values().length;

    }

    @Transactional
    public void salvarServico() throws Exception{
        try {
            servico.setServico(tipoServico);
            servicoService.save(servico);
            FacesUtils.addSuccessMessage("SalvoSucesso");
            servico = new Servico();
        }catch (Exception e){
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
            throw e;
        }
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public TipoServicoEnum getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

}
