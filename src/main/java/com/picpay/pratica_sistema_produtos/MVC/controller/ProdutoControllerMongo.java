package com.picpay.pratica_sistema_produtos.MVC.controller;

import com.picpay.pratica_sistema_produtos.MVC.model.Produto;
import com.picpay.pratica_sistema_produtos.MVC.service.ProdutoServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoControllerMongo implements OpenApiController {
    @Autowired
    private ProdutoServiceMongo produtoService;

    @GetMapping("/listar")
    public List<Produto> listarProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/procurar/{id}")
    public Optional<Produto> procurarProdutoPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping("/adicionar")
    public String adicionarProduto(@RequestBody Produto produto){
        if(produtoService.adicionar(produto) != null){
            return "Produto adicionado com sucesso!!!";
        }
        else {
            return "Este produto já foi cadastrado...";
        }
    }

    @PutMapping("/atualizar")
    public Produto atualizarProduto(@RequestBody Produto produto){
        produtoService.atualizar(produto);

        return produto;
    }


    @DeleteMapping("/deletar/{id}")
    public String deletarProdutos(@PathVariable Long id){
        produtoService.deletar(id);

        return "Produto deletado!!";
    }


}