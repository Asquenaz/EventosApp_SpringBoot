package com.eventoapp.controlles;

import com.eventoapp.Model.Evento;
import com.eventoapp.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/cadastroEvento", method = RequestMethod.GET)
    public String form(){
        return "eventos/formEvento";
    }

    @RequestMapping(value = "/cadastroEvento", method = RequestMethod.POST)
    public String form (@RequestParam("nomeEvento") String nome, @RequestParam("localEvento") String local,
          @RequestParam("dataEvento") String data,@RequestParam("horaEvento") String horaInicioEvento) {

        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setData(data);
        evento.setHoraInicioEvento(horaInicioEvento);
        eventoRepository.save(evento);

        return "redirect:/cadastroEvento";
    }

    @RequestMapping(value = "/eventos")
    public ModelAndView listaEventos(){
        ModelAndView model = new ModelAndView("eventos/viewEvents");
        Iterable<Evento> eventos = eventoRepository.findAll();
        model.addObject("eventos", eventos);

        return model;
    }
}
