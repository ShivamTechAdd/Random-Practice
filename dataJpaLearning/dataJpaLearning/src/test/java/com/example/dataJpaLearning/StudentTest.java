package com.example.dataJpaLearning;
import com.example.dataJpaLearning.Model.Certificate;
import com.example.dataJpaLearning.Model.Student;
import com.example.dataJpaLearning.Repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveStudent() throws IOException {

        Student student1 = new Student();
        student1.setName("Adarsh");
        student1.setCity("Amethi");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration(30);

        student1.setCertificate(certificate);

        Student student2 = new Student();
        student2.setName("Shivam");
        student2.setCity("Lucknow");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("C++");
        certificate2.setDuration(80);

        student2.setCertificate(certificate2);

        studentRepository.save(student1);
        studentRepository.save(student2);

        System.out.println("2 students saved successfully");
    }
}