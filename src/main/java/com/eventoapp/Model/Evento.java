package com.eventoapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class Evento implements Serializable {

    private static  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String Local;
    private String data;
    private String HoraInicioEvento;

}

