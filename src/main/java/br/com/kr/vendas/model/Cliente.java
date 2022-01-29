package br.com.kr.vendas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente extends AbstractEntity{

    @NotNull(message = "O nome do cliente não pode ser vazio!")
    @Column(length = 30)
    private String nome;

    @NotNull(message = "O CPF do cliente não pode ser vazio!")
    @Column(length = 11)
    private Long cpf;

    @NotNull(message = "O email do cliente não pode ser vazio!")
    private String email;


    @NotNull(message = "O Endereço do cliente não pode ser vazio!")
    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;

    public Cliente(String nome, Long cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
