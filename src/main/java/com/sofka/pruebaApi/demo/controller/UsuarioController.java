package com.sofka.pruebaApi.demo.controller;

import com.sofka.pruebaApi.demo.models.UsuarioModel;
import com.sofka.pruebaApi.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService userService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return userService.getUser();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel user){
       return this.userService.saveUser(user);
    }

    /**
     * id parametro, la ruta seria localhost:8080/usuario/1
     * @param id
     * @return
     */
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id ){
        return this.userService.obtenerPorId(id);
    }

    /**
     * los parametros se pasan  localhost:8080/usuario/query?prioridad=5
     * @param prioridad
     * @return
     */
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPriodad(@RequestParam("prioridad") String prioridad){
        return this.userService.obtenerPrioridad(prioridad);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean resp = this.userService.eliminarUsuario(id);
        if (resp){
            return "Se elimino el usuario correctamente";
        }else {
            return "Error al eliminar el usuario";
        }
    }
}
