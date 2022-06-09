package com.sofka.pruebaApi.demo.controller;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ArrayList<RoleModel> obtenerRoles(){
        return this.roleService.getRole();
    }

    @PostMapping
    public RoleModel guardarRole(@RequestBody RoleModel role){
        return this.roleService.saveRole(role);
    }

    @GetMapping("/roleid")
    public Optional<RoleModel> obtenerRoleID(@RequestParam("id") Long id){
        return this.roleService.getRoleId(id);
    }
}
