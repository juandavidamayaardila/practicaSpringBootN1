package com.sofka.pruebaApi.demo.controller;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * Permite obtener los todos los roles.
     *
     * @return Lista RoleModel guardados.
     */
    @GetMapping
    public ArrayList<RoleModel> obtenerRoles(){
        return this.roleService.getRole();
    }

    /**
     * Endpoint Permite guardar un rol
     *
     * @param role Role a ser guardado.
     * @return Role guardado.
     */
    @PostMapping
    public RoleModel guardarRole(@RequestBody RoleModel role){
        return this.roleService.saveRole(role);
    }

    /**
     * EndPoint que permite obtener un role por ID
     * @param id a ser buscado.
     * @return RoleMOdel encontrado.
     */
    @GetMapping("/roleid")
    public Optional<RoleModel> obtenerRoleID(@RequestParam("id") Long id){
        return this.roleService.getRoleId(id);
    }
}
