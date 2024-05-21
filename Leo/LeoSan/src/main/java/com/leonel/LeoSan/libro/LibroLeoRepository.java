package com.leonel.LeoSan.libro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LibroLeoRepository extends CrudRepository<LibroLeo, Long>{
    
    //Para seleccionar todos
    List<LibroLeo> findAll();
}
