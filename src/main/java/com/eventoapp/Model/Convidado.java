package com.eventoapp.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@Entity
public class Convidado implements Serializable {

    private static  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String rg;
    @NotEmpty
    private String nome;

    @ManyToOne
    private Evento evento;

}
