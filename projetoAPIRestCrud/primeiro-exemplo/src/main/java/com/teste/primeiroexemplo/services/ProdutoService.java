package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    
    /**
     * Retorna uma lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        
        return produtoRepository.obterTodos();
    }

    /**
     * Método que retorna o produto encontrado pelo seu id.
     * @param id Id do produto que será localizado.
     * @return Retorna um Optional<Produto> caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
       
        return produtoRepository.obterPorId(id);
    }

    /**
     * Adiciona um produto à lista.
     * @param produto Produto a ser adicionado.
     * @return Retorna o produto adicionado.
     */
    public Produto adicionar(Produto produto) {
        
        return produtoRepository.adicionar(produto);
    }

    /**
     * Método para deletar o produto por id.
     * @param id Id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        produtoRepository.deletar(id);
    }

   /**
    *  Metodo para atualizar o produto na lista. 
    * @param produto que sera atualizado.
    * @return Retorna o produto após atualizar na lista.
    */
    public Produto atualizar(Integer id, Produto produto) {
             produto.setId(id);

             return produtoRepository.atualizar(produto);
    }

}
