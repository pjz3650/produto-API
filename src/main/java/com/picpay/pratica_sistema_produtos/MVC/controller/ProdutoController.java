//package com.picpay.pratica_sistema_produtos.controller;
//
//import com.picpay.pratica_sistema_produtos.model.Produto;
//import com.picpay.pratica_sistema_produtos.service.ProdutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/produto")
//public class ProdutoController {
//    @Autowired
//    private ProdutoService produtoService;
//
//    @GetMapping("/listar")
//    public List<Produto> listarProdutos(){
//        return produtoService.listarProdutos();
//    }
//
//    @GetMapping("/procurar/{id}")
//    public Produto procurarProdutoPorId(@PathVariable Long id){
//        return produtoService.buscarProdutoPorId(id);
//    }
//
//    @PostMapping("/adicionar")
//    public String adicionarProduto(@RequestBody Produto produto){
//        if(produtoService.  adicionarProduto(produto)){
//            return "Produto adicionado com sucesso!!!";
//        }
//        else {
//            return "Este produto já foi cadastrado...";
//        }
//    }
//
//    @PutMapping("/atualizar")
//    public Produto atualizarProduto(@RequestBody Produto produto){
//        produtoService.atualizarProduto(produto);
//
//        return produto;
//    }
//
//
//    @DeleteMapping("/deletar/{id}")
//    public String deletarProdutos(@PathVariable Long id){
//        produtoService.excluirProduto(id);
//
//        return "Produto deletado!!";
//    }
//
//
//}