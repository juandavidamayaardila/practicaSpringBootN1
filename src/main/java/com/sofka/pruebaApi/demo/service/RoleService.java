package com.sofka.pruebaApi.demo.service;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


    public ArrayList<RoleModel> getRole(){
        return (ArrayList<RoleModel>) roleRepository.findAll();
    }

    public RoleModel saveRole(RoleModel role){
        return roleRepository.save(role);
    }

    public Optional<RoleModel> getRoleId(Long id){
        return roleRepository.findById(id);
    }

    public ArrayList<RoleModel> obtenerPorName(String name){
        return roleRepository.findByName(name);

    }
}
