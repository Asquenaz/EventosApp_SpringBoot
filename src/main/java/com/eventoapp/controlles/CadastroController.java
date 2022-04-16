package com.eventoapp.controlles;

import com.eventoapp.Model.Usuario;
import com.eventoapp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioRepository UsuarioRepository;


    @RequestMapping(value = "/telaCadastro")
    public  String telaCadastroUsuario(){

        return "usuario/telaCadastro";
    }

    @RequestMapping(value = "/telaCadastro", method = RequestMethod.POST)
    public String formCadastrarUsuario(@RequestParam("login") String login
                  ,@RequestParam("nomeCompleto") String nomeCompleto
                  ,@RequestParam("senha") String senha){

        Usuario usuario = new Usuario(login, nomeCompleto,
                new BCryptPasswordEncoder().encode(senha));

        UsuarioRepository.save(usuario);

        return "redirect:/";
    }
}
