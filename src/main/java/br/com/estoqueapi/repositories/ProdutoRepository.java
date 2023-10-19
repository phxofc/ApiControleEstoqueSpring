package br.com.estoqueapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estoqueapi.model.ProdutoModel;

public interface ProdutoRepository  extends JpaRepository <ProdutoModel, Long>{
    
    @Query(value = "select (select IFNULL(SUM(e.quantidade),0) from tbl_entrada_produto e where e.produto_id=?1)  -  IFNULL( SUM(s.quantidade) ,0) from tbl_saida_produto s where s.produto_id=?1", nativeQuery = true)
    Integer findByQuantidadeProduto(Long idProduto);
}
