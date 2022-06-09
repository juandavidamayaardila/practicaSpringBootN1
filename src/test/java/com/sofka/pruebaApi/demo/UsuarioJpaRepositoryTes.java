package com.sofka.pruebaApi.demo;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.models.UsuarioModel;
import com.sofka.pruebaApi.demo.repository.RoleRepository;
import com.sofka.pruebaApi.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UsuarioJpaRepositoryTes {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    public void cuandoSeGuardaUnUsuario(){
        UsuarioModel carolina = new UsuarioModel("Carolina","caro@gmail.com","3");
        UsuarioModel jesus = new UsuarioModel("jesus","jesus@gmail.com","3");
        UsuarioModel lina = new UsuarioModel("lina","lina@gmail.com","1");

        RoleModel dba = new RoleModel("DBA");
        RoleModel master = new RoleModel("Scrum Master");
        RoleModel lider = new RoleModel("Lider");


        dba = roleRepository.save(dba);
        master = roleRepository.save(master);
        lider = roleRepository.save(lider);

        carolina.getRoleModels().add(dba);
        carolina.getRoleModels().add(lider);

        jesus.getRoleModels().add(master);
        jesus.getRoleModels().add(lider);

        lina.getRoleModels().add(master);


        carolina = userRepo.save(carolina);
        jesus = userRepo.save(jesus);
        lina = userRepo.save(lina);

        assertNotNull(carolina);
        assertNotNull(jesus);
        assertNotNull(lina);

    }

    @Test
    public void cuandoSeBuscaPorName(){

        UsuarioModel carolina = new UsuarioModel("Carolina","caro@gmail.com","3");
        UsuarioModel jesus = new UsuarioModel("jesus","jesus@gmail.com","3");
        UsuarioModel lina = new UsuarioModel("lina","lina@gmail.com","1");

        carolina = userRepo.save(carolina);
        jesus = userRepo.save(jesus);
        lina = userRepo.save(lina);

        List<UsuarioModel> list = userRepo.findByNombre(carolina.getNombre());
        assertEquals(1,list.size());
    }
}
