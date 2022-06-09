package com.sofka.pruebaApi.demo;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RoleJpaRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Permite probar el guardado de
     * roles.
     */
    @Test
    public void saveRole(){
        /*
        creamos los roles
         */
        RoleModel dba = new RoleModel("DBA");
        RoleModel master = new RoleModel("Scrum Master");
        RoleModel lider = new RoleModel("Lider");

        //Los almacenamos
        dba = roleRepository.save(dba);
        master = roleRepository.save(master);
        lider = roleRepository.save(lider);

        /*
         * Pregutnamos si son null o no
         */
        assertNotNull(dba);
        assertNotNull(master);
        assertNotNull(lider);

    }

    /**
     * Permite probar la busqueda de roles por nombre.
     */
    @Test
    public void cuandoSeBuscaPorName(){

        RoleModel dba = new RoleModel("DBA");
        dba = roleRepository.save(dba);

        List<RoleModel> listRoleModels=roleRepository.findByName(dba.getName());
        assertEquals(1,listRoleModels.size());
    }


}
