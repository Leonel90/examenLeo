package com.leonel.LeoSan.libro;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.ManyToOne;

@RestController
@RequestMapping(value = "/apiLeo/")
public class LibroLeoController {
    
    @Autowired
    private LibroLeoService libroLeoService;

    //Create
    @PostMapping(value = "libro")
    public LibroLeo save(@RequestBody LibroLeo entity)
    {
        return libroLeoService.save(entity);
    }

    //Select by id
    @GetMapping(value = "libro/{id}")
    public LibroLeo getById(@PathVariable Long id)
    {
        return libroLeoService.getById(id);
    }

    //Update
    @PutMapping(value = "libro")
    public LibroLeo update(@RequestBody LibroLeo entity)
    {
        return libroLeoService.save(entity);
    }

    //Delete
    @DeleteMapping(value = "libro/{id}")
    public void delete(@PathVariable Long id)
    {
        libroLeoService.deleteById(id);
    }

    //Select all
    @GetMapping(value = "libro")
    public List<LibroLeo> findAll()
    {
        return libroLeoService.findAll();
    }

    @PatchMapping(value="libro/{id}")
    public LibroLeo partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields){

        LibroLeo libro = getById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                Field campoEntidad = LibroLeo.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);

                if (campoEntidad.isAnnotationPresent(ManyToOne.class)) {
                    java.util.LinkedHashMap<String, Long> keyValue = mapper.convertValue(fieldValue, new TypeReference<java.util.LinkedHashMap<String, Long>>(){});
                    Object relatedEntity = libroLeoService.getById(keyValue.get("id"));
                    campoEntidad.set(libro, relatedEntity);
                }else{
                    campoEntidad.set(libro, fieldValue);
                }

                
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return update(libro);
    }
}
