package com.sofka.pruebaApi.demo.repository;

import com.sofka.pruebaApi.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    /**
     * Metodo que permite buscar por prioridad.
     *
     * @param prioridad criterio de busqueda
     * @return lista con los resultados.
     */
    public abstract ArrayList<UsuarioModel> findByPrioridad(String  prioridad);

    /**
     * Metodo que permite buscar por nombre.
     *
     * @param nombre criterio de busqueda
     * @return lista con los resultados.
     */
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);


}
