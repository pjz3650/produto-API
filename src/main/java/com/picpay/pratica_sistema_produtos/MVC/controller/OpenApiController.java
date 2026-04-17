package com.picpay.pratica_sistema_produtos.MVC.controller;


import com.picpay.pratica_sistema_produtos.MVC.model.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;


@Tag(name = "Produtos")
@RequestMapping("/v1/test-api")
public interface OpenApiController {

    @Operation(summary = "Listar todos os produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = @ArraySchema(schema = @Schema(implementation = Produto.class))))
    })
    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Produto> listarProdutos();


    @Operation(summary = "deletar um produto")
    @Parameter(name = "id", in = PATH, required = true, description = "Deleta o produto com base no identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto deletado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    String deletarProdutos(@PathVariable Long id);



    @Operation(summary = "Procurar produto por ID")
    @Parameter(name = "id", in = PATH, required = true, description = "Procura o produto com base no identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
})
    Optional<Produto> procurarProdutoPorId(@PathVariable Long id);




    @Operation(summary = "Adicionar produto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto adicionado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Produto já cadastrado")
    })
    @PostMapping(value = "/adicionar",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    String adicionarProduto(
            @RequestBody(
                    description = "Dados do produto que será adicionado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Produto.class)))
            @org.springframework.web.bind.annotation.RequestBody Produto produto);



    @Operation(summary = "Atualiza produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping(value = "/atualizar",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    Produto atualizarProduto(
            @RequestBody(
                    description = "Dados que serão atualizados no produto",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Produto.class)))
            @org.springframework.web.bind.annotation.RequestBody Produto produto);
}