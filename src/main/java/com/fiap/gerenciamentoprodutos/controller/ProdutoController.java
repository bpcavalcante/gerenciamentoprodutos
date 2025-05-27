package com.fiap.gerenciamentoprodutos.controller;

import com.fiap.gerenciamentoprodutos.model.Produto;
import com.fiap.gerenciamentoprodutos.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @GetMapping
  public List<Produto> listarProduto(){
    return produtoService.listarProduto();
  }

  @PostMapping
  public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
    Produto produtoCadastrado = produtoService.cadastrarProduto(produto);
    return ResponseEntity.ok(produtoCadastrado);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Integer id){
    Produto produto = produtoService.buscarProdutoPorId(id);
    return ResponseEntity.ok(produto);
  }

  @PutMapping("{id}")
  public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable Integer id){
    Produto produtoCadastrado = produtoService.atualizarProduto(id, produto);
    return ResponseEntity.ok(produtoCadastrado);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> removerProduto(@PathVariable Integer id){
    produtoService.excluirProduto(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/atualizar/estoque/{id}/{quantidade}")
  public ResponseEntity<Produto> atualizarEstoque(@PathVariable Integer id, @PathVariable int quantidade){
    return ResponseEntity.ok(produtoService.atualizarEstoque(id, quantidade));
  }

}
