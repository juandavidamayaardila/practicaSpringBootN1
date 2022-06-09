package com.sofka.pruebaApi.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    private String  nombre;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_role",
        joinColumns = {@JoinColumn(name = "usuario_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")})
    List<RoleModel> roleModels = new ArrayList<RoleModel>();

    private String  prioridad;

    public UsuarioModel() {

    }

    public UsuarioModel( String nombre, String email, String prioridad) {

        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }
}
