package com.curso.Aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", defaultValue = "No envio nada") String texto, Model model){
        model.addAttribute("texto", "El valor enviado fue: ".concat(texto));
        return "params/ver";
    }
}
