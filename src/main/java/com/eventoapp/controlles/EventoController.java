package com.eventoapp.controlles;

import com.eventoapp.Model.Convidado;
import com.eventoapp.Model.Evento;
import com.eventoapp.Repository.ConvidadoRepository;
import com.eventoapp.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @RequestMapping(value = "/cadastroEvento", method = RequestMethod.GET)
    public String form() {
        return "eventos/formEvento";
    }

    @RequestMapping(value = "/cadastroEvento", method = RequestMethod.POST)
    public String formularioEvento(@RequestParam("nomeEvento") String nome, @RequestParam("localEvento") String local,
                       @RequestParam("dataEvento") String data, @RequestParam("horaEvento") String horaInicioEvento) {

        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setData(data);
        evento.setHoraInicioEvento(horaInicioEvento);
        eventoRepository.save(evento);

        return "redirect:/cadastroEvento";
    }

    @RequestMapping(value = "/eventos")
    public ModelAndView listaEventos() {
        ModelAndView model = new ModelAndView("eventos/viewEvents");
        Iterable<Evento> eventos = eventoRepository.findAll();
        model.addObject("eventos", eventos);

        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalheEvento(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("eventos/detalhesEvento");
        Evento evento = eventoRepository.findById(id);
        model.addObject("evento", evento);

        Iterable <Convidado> convidado = convidadoRepository.findByEvento(evento);
        model.addObject("convidado", convidado);

        return model;
    }

    @RequestMapping(value = "/deletar")
    public String deletarEvento(long id){
        Evento evento = eventoRepository.findById(id);
        eventoRepository.delete(evento);

        return "redirect:/eventos";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String convidadoEvento(@PathVariable("id") long id, @Valid Convidado convidado,
                                  BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            redirectAttributes.addAttribute("mensagem",
                    "Erro ao salvar, verifique os campos");

            return "redirect:/{id}";
        }
        Evento evento = eventoRepository.findById(id);
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        redirectAttributes.addFlashAttribute("mensagem", "Dados salvos com sucesso");

        return "redirect:/{id}";
    }

    @RequestMapping(value = "/deletarConvidado")
    public String deletarConvidado( long id){
        Convidado convidado = convidadoRepository.findById(id);
        convidadoRepository.delete(convidado);

        Evento evento = convidado.getEvento();
        long idEv = evento.getId();
        String cod = "" + idEv;


        return "redirect:/" + cod;
    }
}
