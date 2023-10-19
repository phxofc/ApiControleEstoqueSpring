package br.com.estoqueapi.model;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tbl_entrada_produto")
@Entity
public class EntradaProdutoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEntradaProduto;


    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoModel produto;

    @Column(nullable = false)
    private Double preco_und;

    @Column(nullable = false)
    private Integer quantidadeEntrada;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime data_entrada;

   


    

    public EntradaProdutoModel(ProdutoModel produto, Double preco_und, Integer quantidadeEntrada,
            LocalDateTime data_entrada) {
        this.produto = produto;
        this.preco_und = preco_und;
        this.quantidadeEntrada = quantidadeEntrada;
        this.data_entrada = data_entrada;
    }






    public EntradaProdutoModel(){
        
    }






    public Long getIdEntradaProduto() {
        return idEntradaProduto;
    }






    public void setIdEntradaProduto(Long idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
    }






    public ProdutoModel getProduto() {
        return produto;
    }






    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }






    public Double getPreco_und() {
        return preco_und;
    }






    public void setPreco_und(Double preco_und) {
        this.preco_und = preco_und;
    }






    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }






    public void setQuantidadeEntrada(Integer quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }






    public LocalDateTime getData_entrada() {
        return data_entrada;
    }






    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }
    

    


   


    

    





    
    


    
}
