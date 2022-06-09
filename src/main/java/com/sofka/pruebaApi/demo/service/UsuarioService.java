package com.sofka.pruebaApi.demo.service;

import com.sofka.pruebaApi.demo.models.UsuarioModel;
import com.sofka.pruebaApi.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    final
    UsuarioRepository userRepo;

    public UsuarioService(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Permite obtner una lista de usuario almacenados.
     *
     * @return lista con los usuarios.
     */
    public ArrayList<UsuarioModel> getUser(){
       return (ArrayList<UsuarioModel>) userRepo.findAll();
    }

    /**
     * Permite guardar un usuario.
     *
     * @param userModel usuario a ser almacenado
     * @return usuario almacenado.
     */
    public UsuarioModel saveUser(UsuarioModel userModel){

        return userRepo.save(userModel);
    }


    /**
     * Permite buscar un usuario por id.
     * Optional permite controlar el caso que no haya ningun
     * usuario con ese id
     *
     * @param id cruterio de busqueda
     * @return usuario encontrado
     */
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return userRepo.findById(id);
    }

    /**
     * Permite obtener una lista de usuarios segun la
     * prioridad.
     *
     * @param prioridad criterio de busqueda
     * @return lista con los resultados.
     */
    public ArrayList<UsuarioModel> obtenerPrioridad(String prioridad){
        return userRepo.findByPrioridad(prioridad);
    }

    /**
     * Permite eliminar un usuario por id
     *
     * @param id criterio de eliminacion
     * @return true o false
     */
    public boolean eliminarUsuario(Long id){
        try {
            userRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


}
