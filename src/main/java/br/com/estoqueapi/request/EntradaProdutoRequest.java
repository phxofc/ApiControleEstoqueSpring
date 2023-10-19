package br.com.estoqueapi.request;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import br.com.estoqueapi.model.EntradaProdutoModel;
import br.com.estoqueapi.model.ProdutoModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class EntradaProdutoRequest {

    @NotNull
    @Positive
    @PositiveOrZero
    private Integer quantidadeEntradaRequest;
    @NotNull
    @PositiveOrZero
    private Double precoUnitario;
    @PastOrPresent

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataEntrada;


    public EntradaProdutoRequest(@NotNull @Positive Integer quantidadeEntradaRequest, @NotNull @PositiveOrZero Double precoUnitario,
            LocalDateTime dataEntrada) {
        this.quantidadeEntradaRequest = quantidadeEntradaRequest;
        this.precoUnitario = precoUnitario;
        this.dataEntrada = dataEntrada;
    }
    

    public EntradaProdutoModel toModelo(ProdutoModel produtoModel){
        return new EntradaProdutoModel(produtoModel, precoUnitario, quantidadeEntradaRequest, dataEntrada);
    }



    
    
}
