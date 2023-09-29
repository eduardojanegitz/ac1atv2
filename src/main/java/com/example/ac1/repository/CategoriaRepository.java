package com.example.ac1.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNomeLike(String nome);
    
    //   @Query("SELECT DISTINCT P.NOME FROM CATEGORIA C LEFT JOIN PRODUTO P ON P.CATEGORIA_ID = C.ID WHERE C.ID = :id")
    // List<Categoria> findWithProdutosById(@Param("id") long id);
}
