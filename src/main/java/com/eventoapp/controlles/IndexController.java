package com.eventoapp.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "usuario/telaLogin";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  String teste(){
        //Validação se ta no banco
        return "index";
    }

    @RequestMapping(value = "/telaCadastro")
    public  String teste1(){

        return "usuario/telaCadastro";
    }
}
