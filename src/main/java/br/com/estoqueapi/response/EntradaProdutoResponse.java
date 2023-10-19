package br.com.estoqueapi.response;

import br.com.estoqueapi.model.EntradaProdutoModel;

public class EntradaProdutoResponse {


    private Long produto;
    private Integer quantidadeEntrada;


    public EntradaProdutoResponse(EntradaProdutoModel entradaProdutoModel) {
        this.produto = entradaProdutoModel.getProduto().getId();
        this.quantidadeEntrada = entradaProdutoModel.getQuantidadeEntrada();
    }
    


    public Long getProduto() {
        return produto;
    }


    


    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }


    
    

    

    
    
}
