package com.eventoapp.controlles;

import com.eventoapp.Model.Usuario;
import com.eventoapp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String formCadastrarUsuario(@RequestParam("nomeUsuario") String nome,
                  @RequestParam("ultimoNome") String ultimoNome,@RequestParam("email") String email
                  ,@RequestParam("senha") String senha, @RequestParam("confirmSenha") String confirmSenha){

        Usuario usuario = new Usuario(nome,
                ultimoNome, email, senha,
                confirmSenha);

        UsuarioRepository.save(usuario);

        return "redirect:/";
    }

}
