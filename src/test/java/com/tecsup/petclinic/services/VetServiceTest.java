package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testFindVetById() {

        Integer ID = 1;
        String FIRST_NAME = "James";
        Vet vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("" + vet);
        assertEquals(FIRST_NAME, vet.getFirstName());

    }

    @Test
    public void testFindVetByFirstName() {

        String FIRST_NAME = "James";
        int EXPECTED_SIZE = 1;

        List<Vet> vets = this.vetService.findByFirstName(FIRST_NAME);

        assertEquals(EXPECTED_SIZE, vets.size());
    }

    @Test
    public void testFindVetByLastName() {

        String LAST_NAME = "Carter";
        int EXPECTED_SIZE = 1;

        List<Vet> vets = this.vetService.findByLastName(LAST_NAME);

        assertEquals(EXPECTED_SIZE, vets.size());
    }

    @Test
    public void testCreateVet() {

        String FIRST_NAME = "John";
        String LAST_NAME = "Doe";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        Vet vetCreated = this.vetService.create(vet);

        log.info("VET CREATED :" + vetCreated);

        assertNotNull(vetCreated.getId());
        assertEquals(FIRST_NAME, vetCreated.getFirstName());
        assertEquals(LAST_NAME, vetCreated.getLastName());
    }
    @Test
    public void testUpdateVet() {

        String FIRST_NAME = "John";
        String LAST_NAME = "Doe";

        String UP_FIRST_NAME = "Johnny";
        String UP_LAST_NAME = "DoeUpdated";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        // Create
        Vet vetCreated = this.vetService.create(vet);

        // Update
        vetCreated.setFirstName(UP_FIRST_NAME);
        vetCreated.setLastName(UP_LAST_NAME);

        Vet vetUpdated = this.vetService.update(vetCreated);

        assertEquals(UP_FIRST_NAME, vetUpdated.getFirstName());
        assertEquals(UP_LAST_NAME, vetUpdated.getLastName());
    }

    @Test
    public void testDeleteVet() {

        String FIRST_NAME = "Jane";
        String LAST_NAME = "Smith";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        // Create
        vet = this.vetService.create(vet);

        Integer id = vet.getId();

        // Delete
        try {
            this.vetService.delete(id);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // Validate
        try {
            this.vetService.findById(id);
            fail("Vet should not be found");
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }
    }




}
