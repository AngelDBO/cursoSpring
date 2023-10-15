package com.curso.Aplicacion.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", defaultValue = "No envio nada") String texto, Model model) {
        model.addAttribute("texto", "El valor enviado fue: ".concat(texto));
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("texto", "El saludo enviado fue: ".concat(saludo) + " y el numero es: " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("texto", "El saludo enviado fue: ".concat(saludo) + " y el numero es: " + numero);
        return "params/ver";
    }
}
