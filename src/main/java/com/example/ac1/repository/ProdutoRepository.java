package com.example.ac1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeLike(String nome);
    List<Produto> findByIdLike(int id);

    List<Produto> findByPrecoGreaterThan(Double preco);

    // List<Produto> findByPrecoLess(Double preco);
   
}
