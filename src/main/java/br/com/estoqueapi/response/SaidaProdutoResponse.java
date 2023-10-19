package br.com.estoqueapi.response;

import br.com.estoqueapi.model.SaidaProdutoModel;

public class SaidaProdutoResponse {

    private Long produto;
    private Integer quantidade_saida;


    public SaidaProdutoResponse(SaidaProdutoModel saidaProdutoModel) {
        this.produto = saidaProdutoModel.getProduto().getId();
        this.quantidade_saida = saidaProdutoModel.getQuantidade_saida();
    }


    public Long getProduto() {
        return produto;
    }


    public Integer getQuantidadeSaida() {
        return quantidade_saida;
    }

    

    
    
}
