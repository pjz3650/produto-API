package com.picpay.pratica_sistema_produtos.MVC.repository;

import com.picpay.pratica_sistema_produtos.MVC.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryMongo extends MongoRepository<Produto, Long> {

}
