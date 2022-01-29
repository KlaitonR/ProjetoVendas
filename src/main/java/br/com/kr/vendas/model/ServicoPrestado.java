package br.com.kr.vendas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "servico_prestado")
public class ServicoPrestado extends AbstractEntity{

    @OneToMany(fetch = FetchType.LAZY)
    private List<Servico> servicos;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @NotNull
    @Column(name = "horas_trabalhadas")
    private Date horasTrabalhadas;

    @NotNull
    @Column(name = "data_realizacao")
    private Date data;

    @NotNull
    @Column(name = "valor_total")
    private Double valorTotal;

    public ServicoPrestado() {

    }

    public ServicoPrestado(List<Servico> servicos, List<Produto> produtos, Cliente cliente, Date horasTrabalhadas, Date data, Double valorTotal) {
        this.servicos = servicos;
        this.produtos = produtos;
        this.cliente = cliente;
        this.horasTrabalhadas = horasTrabalhadas;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Date horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
