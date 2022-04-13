package com.eventoapp.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
public class Evento implements Serializable {

    private static  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String local;
    @NotEmpty
    private String data;
    @NotEmpty
    private String horaInicioEvento;
    @OneToMany
    private List<Convidado> convidado;
}

