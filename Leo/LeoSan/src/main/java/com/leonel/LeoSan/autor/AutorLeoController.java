package com.leonel.LeoSan.autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/apiLeo/")
public class AutorLeoController {
    
    @Autowired
    private AutorLeoService autorLeoService;

    //Create
    @PostMapping(value = "autor")
    public AutorLeo save(@RequestBody AutorLeo entity)
    {
        return autorLeoService.save(entity);
    }

    //Select by id
    @GetMapping(value = "categoria/{id}")
    public AutorLeo getById(@PathVariable Long id)
    {
        return autorLeoService.getById(id);
    }

    @PutMapping(value = "categoria/{id}")
    
    public ResponseEntity<AutorLeo> actualizarAutorLeo(@PathVariable Long id, @RequestBody AutorLeo autorLeoActualizada) 
    {
        return autorLeoService.actualizarAutorLeo(id, autorLeoActualizada);
    }

    //Delete
    @DeleteMapping(value = "autor/{id}")
    public void delete(@PathVariable Long id)
    {
        autorLeoService.deleteById(id);
    }

    //Delete-Nombre

    //Select all
    @GetMapping(value = "autor")
    public List<AutorLeo> findAll()
    {
        return autorLeoService.findAll();
    }
}
