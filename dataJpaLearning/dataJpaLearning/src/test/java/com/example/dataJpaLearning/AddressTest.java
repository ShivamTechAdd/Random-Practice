package com.example.dataJpaLearning;

import com.example.dataJpaLearning.Model.Address;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootTest
class AddressTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    void saveAddress() throws IOException {

        Address address = new Address();

        address.setStreet("MG Road");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(LocalDate.now());
        address.setX(123.555);

        // Reading image
        FileInputStream fis = new FileInputStream("src/main/java/pic.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);

        entityManager.persist(address);

        System.out.println("Address saved successfully");
    }





}
