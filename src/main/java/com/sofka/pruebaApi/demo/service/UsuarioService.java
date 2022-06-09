package com.sofka.pruebaApi.demo.service;

import com.sofka.pruebaApi.demo.models.UsuarioModel;
import com.sofka.pruebaApi.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository userRepo;

    public ArrayList<UsuarioModel> getUser(){
       return (ArrayList<UsuarioModel>) userRepo.findAll();
    }

    public UsuarioModel saveUser(UsuarioModel userModel){

        return userRepo.save(userModel);
    }


    /**
     * Optional permite controlar el caso que no haya ningun
     * usuario con ese id
     *
     * @param id
     * @return
     */
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return userRepo.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPrioridad(String prioridad){
        return userRepo.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            userRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
