package com.leonel.LeoSan.autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AutorLeoService {
    
    @Autowired
    private AutorLeoRepository autorLeoRepository;

    //Para crear
    public AutorLeo save(AutorLeo entity)
    {
        return autorLeoRepository.save(entity);
    }

    //Para seleccionar por id
    public AutorLeo getById(Long id)
    {
        return autorLeoRepository.findById(id).orElse(null);
    }

    //Para borrar
    public void deleteById(Long  id){
        autorLeoRepository.deleteById(id);
    }

    //Para borrar por nombre
    
    //Para seleccionar todos
    public List<AutorLeo> findAll(){
        return autorLeoRepository.findAll();
    }

    //Update
     public ResponseEntity<AutorLeo> actualizarAutorLeo(Long id, AutorLeo autorLeoActualizada) 
    {
        try {
            // Verificar si la categoría con el ID dado existe en la base de datos
            AutorLeo autorLeoExistente = getById(id);
            if (autorLeoExistente == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los campos de la categoría existente con los valores de la categoría actualizada
            if(autorLeoActualizada.getNameAutor()!=null)
            {
                autorLeoExistente.setNameAutor(autorLeoActualizada.getNameAutor());
            } 
            
            if(autorLeoActualizada.getEnable()!=null)
            {
                autorLeoExistente.setEnable(autorLeoActualizada.getEnable());
            } 
            // Guardar los cambios en la base de datos
            AutorLeo autorLeoGuardada = save(autorLeoExistente);
            return ResponseEntity.ok(autorLeoGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
