package com.picpay.pratica_sistema_produtos.MVC.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Data
@Document(collection = "produtos")
public class Produto {
    @Id
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;

}