package com.curso.Aplicacion.controller;

import com.curso.Aplicacion.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping(value = {"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola desde spring");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Pablo");
        usuario.setApellido("Laslo");
        usuario.setEmail("correo@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Datos del usuario ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("titulo", "Listado de usuarios");
        //model.addAttribute("usuarios", usuarios);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Laslo", "Qwerty", "laslo@correo.com"));
        usuarios.add(new Usuario("Moto", "Carro", "moto@correo.com"));
        usuarios.add(new Usuario("Carro", "Honda", "carro@correo.com"));
        usuarios.add(new Usuario("Lancha", "Yamaha", "lancha@correo.com"));
        usuarios.add(new Usuario("Yate", "Suzuki", "yate@correo.com"));

        return usuarios;
    }
}
