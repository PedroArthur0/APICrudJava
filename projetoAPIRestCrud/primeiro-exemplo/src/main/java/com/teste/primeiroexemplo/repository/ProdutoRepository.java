package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.execption.ResourceNotFundExecption;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();
    private int ultimoId = 0;

    /**
     * Retorna uma lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu id.
     * @param id Id do produto que será localizado.
     * @return Retorna um Optional<Produto> caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
            .stream()
            .filter(produto -> produto.getId() == id)
            .findFirst();
    }

    /**
     * Adiciona um produto à lista.
     * @param produto Produto a ser adicionado.
     * @return Retorna o produto adicionado.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Método para deletar o produto por id.
     * @param id Id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto atualizar(Produto produto) {
        
        // Encontrar o produto 
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
       
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFundExecption("Produto não encontrado");
        }
        
        // Remover o antigo produto.
        deletar(produto.getId());
       
        // Adicionar o novo produto na lista.
        produtos.add(produto);
        
        return produto;
    }
}

