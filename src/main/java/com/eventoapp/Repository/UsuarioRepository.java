package com.eventoapp.Repository;

import com.eventoapp.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByLogin(String login);


}
