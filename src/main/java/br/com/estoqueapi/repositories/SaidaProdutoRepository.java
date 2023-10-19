package br.com.estoqueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estoqueapi.model.SaidaProdutoModel;

public interface SaidaProdutoRepository extends JpaRepository<SaidaProdutoModel, Long> {
    
}
