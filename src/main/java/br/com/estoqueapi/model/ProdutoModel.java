package br.com.estoqueapi.model;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Table(name = "tbl_produto")
@Entity
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime criado_em;
    @Column(nullable = false)
    @NotNull
    @Positive
    private Integer quantidadeEstoque;


    public ProdutoModel(String nome, String descricao, LocalDateTime criado_em, Integer quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.criado_em = criado_em;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    


    public ProdutoModel() {
    }




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDateTime getCriado_em() {
        return criado_em;
    }


    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }


    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    
    

    


    
   

}
