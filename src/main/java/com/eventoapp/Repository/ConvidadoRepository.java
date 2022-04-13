package com.eventoapp.Repository;

import com.eventoapp.Model.Convidado;
import com.eventoapp.Model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
    Iterable <Convidado> findByEvento(Evento evento);
    Convidado findById(long id);
}
