package com.eventoapp.Repository;

import com.eventoapp.Model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findById(long id);
}
