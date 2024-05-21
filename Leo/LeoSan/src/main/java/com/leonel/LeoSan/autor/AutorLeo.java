package com.leonel.LeoSan.autor;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AutorLeo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    private Long idAutor;
    private String nameAutor;
    private int ageAutor;
    private Boolean enable; 
    private Date fNacimientoAutor;
}
