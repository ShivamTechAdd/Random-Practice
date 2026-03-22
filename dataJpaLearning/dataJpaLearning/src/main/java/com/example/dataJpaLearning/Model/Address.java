package com.example.dataJpaLearning.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long AddressId;

    @Column(length = 50,name = "Street")
    private String street;

    @Column(length = 100,name = "City")
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient
    private double x;

    @Temporal(TemporalType.DATE)
    @Column(name = "added_date")
    private LocalDate addedDate;

    @Lob
    private byte[] image;

}
