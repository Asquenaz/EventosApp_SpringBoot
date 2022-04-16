package com.eventoapp.controlles;

import com.eventoapp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/login")
    public String login(){
        return "usuario/telaLogin";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        return "usuario/telaLogin";
    }


/*    @RequestMapping(value = "/")
    public  String index() {
        return "index";
    }*/
}
