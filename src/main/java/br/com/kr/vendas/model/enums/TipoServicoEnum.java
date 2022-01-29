package br.com.kr.vendas.model.enums;

public enum TipoServicoEnum {

    CONSERTO_DE_MOTORES_ELETRICOS("Conserto de Motores Elétricos"),
    CONSERTO_DE_APARELHOS_ELETRONICOS("Conserto de aparelhos eletrônicos"),
    INSTALACAO_ELETRICA_RESIDENCIAL("Instalação elétrica residencial"),
    INSTALACAO_ELETRICA_EMPRESARIAL("Instalação elétrica empresarial");

    private String descricao;

    TipoServicoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
