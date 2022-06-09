package com.sofka.pruebaApi.demo;

import com.sofka.pruebaApi.demo.models.RoleModel;
import com.sofka.pruebaApi.demo.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RoleJpaRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveRole(){
        RoleModel dba = new RoleModel("DBA");
        RoleModel master = new RoleModel("Scrum Master");
        RoleModel lider = new RoleModel("Lider");

        dba = roleRepository.save(dba);
        master = roleRepository.save(master);
        lider = roleRepository.save(lider);

        assertNotNull(dba);
        assertNotNull(master);
        assertNotNull(lider);

    }

    @Test
    public void cuandoSeBuscaPorName(){

        RoleModel dba = new RoleModel("DBA");
        dba = roleRepository.save(dba);

        List<RoleModel> listRoleModels=roleRepository.findByName("DBA");
        assertEquals(1,listRoleModels.size());
    }


}
