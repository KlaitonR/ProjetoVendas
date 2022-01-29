package br.com.kr.vendas.model;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Produto extends AbstractEntity{

    @NotNull(message = "O nome do produto não pode ser vazio!")
    private String nome;

    @NotNull(message = "O valor do produto não pode ser vazio!")
    @DecimalMin(message = "O valor precisa ser maior que 0.0 reais!", value = "0.0")
    private Double valor;

    @NotNull(message = "O estoque do produto não pode ser vazio!")
    @Min(message = "A quantidade precisa ser maior ou igual a 1 unidade!", value = 1)
    private Integer estoque;

    @Transient
    private transient boolean editando;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}
