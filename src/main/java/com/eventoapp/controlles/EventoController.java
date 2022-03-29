package com.eventoapp.controlles;

import com.eventoapp.Model.Evento;
import com.eventoapp.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/CadastroEvento" , method = RequestMethod.GET)
    @GetMapping
    public String form(){
        return "eventos/formEvento";
    }

    @RequestMapping(value = "/CadastroEvento" , method = RequestMethod.POST)
    public String form (Evento ev){
        eventoRepository.save(ev);
        return "redirect:/CadastroEvento";
    }
}
