package com.fiap.gerenciamentoprodutos.service;

import com.fiap.gerenciamentoprodutos.model.Produto;
import com.fiap.gerenciamentoprodutos.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> listarProduto() {
    return produtoRepository.findAll();
  }

  public Produto cadastrarProduto(Produto produto){
    return produtoRepository.save(produto);
  }

  public Produto buscarProdutoPorId(Integer id){
    Produto produto = produtoRepository.findById(id).orElse(null);

    if(produto != null){
      return produto;
    } else {
      throw new IllegalArgumentException("Produto não encontrado");
    }
  }

  public Produto atualizarProduto(Integer id, Produto produto){
    Produto produtoAtual = produtoRepository.findById(id).orElse(null);
    if(produtoAtual != null){
      produtoAtual.setNome(produto.getNome());
      produtoAtual.setDescricao(produto.getDescricao());
      produtoAtual.setPreco(produto.getPreco());
      return produtoRepository.save(produtoAtual);
    }

    throw new IllegalArgumentException("Este Produto não foi encontrado");
  }

  public void excluirProduto(Integer id){
    produtoRepository.deleteById(id);
  }

  public Produto atualizarEstoque(Integer produtoId, int quantidade) {
    Produto produtoAtual = produtoRepository.findById(produtoId).orElse(null);
    if(produtoAtual != null){
      produtoAtual.setQuantidade_estoque(produtoAtual.getQuantidade_estoque() - quantidade);

      return produtoRepository.save(produtoAtual);
    }

    return null;
  }

}
