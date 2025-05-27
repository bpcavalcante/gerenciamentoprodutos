package com.fiap.gerenciamentoprodutos.repository;

import com.fiap.gerenciamentoprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
