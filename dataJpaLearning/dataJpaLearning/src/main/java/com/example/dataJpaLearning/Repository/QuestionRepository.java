package com.example.dataJpaLearning.Repository;

import com.example.dataJpaLearning.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
