package com.sofka.pruebaApi.demo.repository;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    public abstract ArrayList<RoleModel> findByName(String name);
}
