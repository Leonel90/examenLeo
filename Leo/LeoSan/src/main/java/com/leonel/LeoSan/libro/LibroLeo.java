package com.leonel.LeoSan.libro;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leonel.LeoSan.autor.AutorLeo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class LibroLeo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idLibro;
    private String titleLibro;
    private int yearPubLibro;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date fechaCreationDate;

    //Relacion
    @ManyToOne
    private AutorLeo categoria;
}
