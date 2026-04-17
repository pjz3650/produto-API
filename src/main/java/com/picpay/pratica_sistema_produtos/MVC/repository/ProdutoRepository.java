//package com.picpay.pratica_sistema_produtos.repository;
//
//import com.picpay.pratica_sistema_produtos.model.Produto;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Component
//public class ProdutoRepository {
//
//    private final List<Produto> produtos = new ArrayList<>();
//
//    public Produto save(Produto produto) {
//        produtos.add(produto);
//        return produto;
//    }
//
//
//    public List<Produto> findAll() {
//        return new ArrayList<>(produtos);
//    }
//
//
//    public Produto findById(Long id) {
//        return (Produto) produtos.stream()
//                .filter(produto -> produto.getId().equals(id))
//                .findFirst()
//                .orElse(Produto.builder()
//                        .id(0L)
//                        .nome("")
//                        .descricao("")
//                        .preco(0.0)
//                        .build());
//    }
//
//
//    public boolean delete(Long id) {
//        return produtos.removeIf(p -> p.getId().equals(id));
//    }
//
//
//    public void update(Produto produto) {
//        produtos.stream()
//                .filter(p -> p.getId().equals(produto.getId()))
//                .findFirst()
//                .ifPresent(p -> {
//                    p.setNome(produto.getNome());
//                    p.setDescricao(produto.getDescricao());
//                    p.setPreco(produto.getPreco());
//                });
//    }
//}