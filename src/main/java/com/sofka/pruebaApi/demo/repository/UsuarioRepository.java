package com.sofka.pruebaApi.demo.repository;

import com.sofka.pruebaApi.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByPrioridad(String  prioridad);

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
}
