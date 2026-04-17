package com.picpay.pratica_sistema_produtos.MVC.service;

import com.picpay.pratica_sistema_produtos.MVC.model.Produto;
import com.picpay.pratica_sistema_produtos.MVC.repository.ProdutoRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceMongo {

    private final ProdutoRepositoryMongo repositoryMongo;

    public ProdutoServiceMongo(ProdutoRepositoryMongo repositoryMongo) {
        this.repositoryMongo = repositoryMongo;
    }


    public Produto adicionar(Produto produto) {
        return repositoryMongo.save(produto);
    }

    public List<Produto> listarTodos() {
        return repositoryMongo.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repositoryMongo.findById(id);
    }

    public boolean deletar(Long id) {
        if (!repositoryMongo.existsById(id)) {
            return false;
        }
        repositoryMongo.deleteById(id);
        return true;
    }

    public void atualizar(Produto produto) {
        repositoryMongo.findById(produto.getId())
                .map(p -> {
                    p.setNome(produto.getNome());
                    p.setDescricao(produto.getDescricao());
                    p.setPreco(produto.getPreco());
                    p.setEstoque(produto.getEstoque());
                    return repositoryMongo.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
