package com.leonel.LeoSan.autor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AutorLeoRepository extends CrudRepository<AutorLeo, Long>{

    //Para seleccionar todos
    List<AutorLeo> findAll();
    
}