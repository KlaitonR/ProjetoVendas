package br.com.kr.vendas.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco extends AbstractEntity{

//    @NotNull(message = "O logradouro não pode ser vazio!")
    private String logradouro;

//    @NotNull(message = "A cidade não pode ser vazio!")
    private String cidade;

//    @NotNull(message = "O cep não pode ser vazio!")
    private String cep;

    private String UF;

    private Integer numero;

    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}