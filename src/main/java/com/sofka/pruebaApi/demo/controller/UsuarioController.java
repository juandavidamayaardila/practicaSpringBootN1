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

    /**
     * EndPoint que permite obtener los usuarios.
     *
     * @return lista con los usuarios encontradod.
     */
    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return userService.getUser();
    }

    /**
     * EndPoint que guarda los usuarios.
     *
     * @param user usuario a ser almacenado
     * @return usuario almacenado
     */
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel user){
       return this.userService.saveUser(user);
    }

    /**
     * EndPoint put que permite actualizar un usuario
     *
     * @param user usuario a ser actualizado
     * @return usuario actualizado.
     */
    @PutMapping("/update")
    @PostMapping
    public UsuarioModel updateUsuario(@RequestBody UsuarioModel user){
        return this.userService.saveUser(user);
    }

    /**
     * EndPoint que permite buscar un usuario por id, pasando
     * el id como parametro.
     * id parametro, la ruta seria localhost:8080/usuario/1
     * @param id criterio de busqueda.
     * @return usuario encontrado.
     */
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id ){
        return this.userService.obtenerPorId(id);
    }

    /**
     * EndPoint que permite buscar por prioridad, pasando
     * como parametro la prioridad.
     * los parametros se pasan  localhost:8080/usuario/query?prioridad=5
     * @param prioridad
     * @return
     */
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPriodad(@RequestParam("prioridad") String prioridad){
        return this.userService.obtenerPrioridad(prioridad);
    }


    /**
     * EndPoint que permite eliminar un usuario,
     * por medio del id, parametro.
     *
     * @param id criterio de eliminacion.
     * @return true o false
     */
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
