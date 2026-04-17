//package com.picpay.pratica_sistema_produtos.service;
//
//import com.picpay.pratica_sistema_produtos.model.Produto;
//import com.picpay.pratica_sistema_produtos.repository.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Component
//public class ProdutoService {
//    private final ProdutoRepository repository;
//
//    public ProdutoService(ProdutoRepository repository2) {
//        this.repository = repository2;
//    }
//
//    public boolean adicionarProduto(Produto produto) {
//        List<Produto> produtos = new ArrayList<>(repository.findAll());
//        if (produtos.stream().noneMatch(p -> p.getId().equals(produto.getId()))){
//            repository.save(produto);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Produto> listarProdutos() {
//        return repository.findAll();
//    }
//
//    public Produto buscarProdutoPorId(Long id) {
//        return repository.findById(id);
//    }
//
//    public void excluirProduto(Long id) {
//        Produto produto = (repository.findById(id));
//        repository.delete(produto.getId());
//    }
//
//    public void atualizarProduto(Produto produto) {
//        repository.update(produto);
//    }
//
//}
