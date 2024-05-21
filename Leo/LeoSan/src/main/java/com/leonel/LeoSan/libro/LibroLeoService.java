package com.leonel.LeoSan.libro;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroLeoService {
    
    @Autowired
    private LibroLeoRepository libroLeoRepository;

    //Para crear
    public LibroLeo save(LibroLeo entity)
    {
        return libroLeoRepository.save(entity);
    }

    //Para seleccionar por id
    public LibroLeo getById(Long id)
    {
        return libroLeoRepository.findById(id).orElse(null);
    }

    //Para borrar
    public void deleteById(Long  id){
        libroLeoRepository.deleteById(id);
    }
    
    //Para seleccionar todos
    public List<LibroLeo> findAll(){
        return libroLeoRepository.findAll();
    }

    //Actualizar por partes
    public LibroLeo actualizarLibro(LibroLeo libroLeoActualizado) {
        // Verifica si el libro existe en la base de datos
        LibroLeo libroLeoExistente = libroLeoRepository.findById(libroLeoActualizado.getIdLibro())
                                              .orElseThrow(() -> new NoSuchElementException("Libro no encontrado"));
        // Actualiza los campos del libro existente con los valores del libro actualizado
        libroLeoExistente.setTitleLibro(libroLeoActualizado.getTitleLibro());
        libroLeoExistente.setYearPubLibro(libroLeoActualizado.getYearPubLibro());
        libroLeoExistente.setFechaCreationDate(libroLeoActualizado.getFechaCreationDate());
        libroLeoExistente.setCategoria(libroLeoActualizado.getCategoria());

        // Guarda los cambios en la base de datos
        return libroLeoRepository.save(libroLeoExistente);
    }
}
