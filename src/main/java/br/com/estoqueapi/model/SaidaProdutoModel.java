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


@Table(name="tbl_saida_produto")
@Entity
public class SaidaProdutoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idSaidaProduto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoModel produto;
    @Column(nullable = false)
    private Integer quantidade_saida;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime data_saida;




    
   

    public SaidaProdutoModel(ProdutoModel produto, Integer quantidade_saida, LocalDateTime data_saida) {
        this.produto = produto;
        this.quantidade_saida = quantidade_saida;
        this.data_saida = data_saida;
    }

    public SaidaProdutoModel(){
        
    }

    public Long getIdSaidaProduto() {
        return idSaidaProduto;
    }

    public void setIdSaidaProduto(Long idSaidaProduto) {
        this.idSaidaProduto = idSaidaProduto;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public Integer getQuantidade_saida() {
        return quantidade_saida;
    }

    public void setQuantidade_saida(Integer quantidade_saida) {
        this.quantidade_saida = quantidade_saida;
    }

    public LocalDateTime getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDateTime data_saida) {
        this.data_saida = data_saida;
    }
   
   


    





    
}
