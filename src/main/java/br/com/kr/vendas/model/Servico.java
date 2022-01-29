package br.com.kr.vendas.model;

import br.com.kr.vendas.model.enums.TipoServicoEnum;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Servico extends AbstractEntity{

    private TipoServicoEnum servico;

    private Double valor;

    @Transient
    private transient boolean editando;

    public TipoServicoEnum getServico() {
        return servico;
    }

    public void setServico(TipoServicoEnum servico) {
        this.servico = servico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}
