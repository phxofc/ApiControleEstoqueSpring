package br.com.estoqueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estoqueapi.model.EntradaProdutoModel;

public interface EntradaProdutoRepository extends JpaRepository<EntradaProdutoModel, Long> {
    
}
