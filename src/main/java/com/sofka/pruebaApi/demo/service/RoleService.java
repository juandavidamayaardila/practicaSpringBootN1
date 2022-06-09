package com.sofka.pruebaApi.demo.service;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {

    final
    RoleRepository roleRepository;

    /**
     * Inyectamos dependencia meidante constructor.
     *
     * @param roleRepository repositorio
     */
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    /**
     * Metodo que obtiene todos los roles almacenados.
     *
     * @return lista de roles encontrados.
     */
    public ArrayList<RoleModel> getRole(){
        return (ArrayList<RoleModel>) roleRepository.findAll();
    }

    /**
     * Permite guardar un role.
     *
     * @param role a ser almacenado
     * @return el role almacenado.
     */
    public RoleModel saveRole(RoleModel role){
        return roleRepository.save(role);
    }

    /**
     * Permite obtener un role por id
     *
     * @param id criterio de busqeuda
     * @return role encontrado.
     */
    public Optional<RoleModel> getRoleId(Long id){
        return roleRepository.findById(id);
    }

    /**
     * Permite obtener la lista de roles por nombre
     *
     * @param name criterio de busqueda.
     * @return lista de roles encontrados.
     */
    public ArrayList<RoleModel> obtenerPorName(String name){
        return roleRepository.findByName(name);

    }
}
