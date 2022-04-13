package com.eventoapp.controlles;

import com.eventoapp.Model.Usuario;
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

    @RequestMapping(value = "/")
    public String index(){
        return "usuario/telaLogin";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  String validarLogin(@RequestParam("email")
                String email,@RequestParam("senha") String senha) {

        return "";
    }
}
