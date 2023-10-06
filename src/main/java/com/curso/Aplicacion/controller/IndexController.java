package com.curso.Aplicacion.controller;

import com.curso.Aplicacion.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping(value = {"/index", "/", "", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola desde spring");
        return  "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Pablo");
        usuario.setApellido("Laslo");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Datos del usuario ".concat(usuario.getNombre()));
        return  "perfil";
    }
}
