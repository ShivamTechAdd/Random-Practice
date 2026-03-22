package com.example.dataJpaLearning.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @Column(name = "question_id")
    private Integer questionId;

    private String question;

    @OneToOne
    @JoinColumn(name = "a_id")
    @JsonIgnore
    @ToString.Exclude
    private Answer answer;
}
