package br.com.estoqueapi.request;


import java.time.LocalDateTime;

import br.com.estoqueapi.model.ProdutoModel;
import br.com.estoqueapi.model.SaidaProdutoModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class SaidaProdutoRequest {

    @NotNull
    @PositiveOrZero
    private Integer quantidade_saida;

    @PastOrPresent
    private LocalDateTime dataSaida;


    public SaidaProdutoRequest(@NotNull Integer quantidade_saida, LocalDateTime dataSaida) {
        this.quantidade_saida = quantidade_saida;
        this.dataSaida = dataSaida;
    }
    public SaidaProdutoModel toModelo(ProdutoModel produtoModel){
        return new SaidaProdutoModel(produtoModel, quantidade_saida,dataSaida);
    }
    public Integer getQuantidade() {
        return quantidade_saida;
    }
    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    


}

 
