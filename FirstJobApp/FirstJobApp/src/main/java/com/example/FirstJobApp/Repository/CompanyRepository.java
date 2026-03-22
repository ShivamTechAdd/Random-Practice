package com.example.FirstJobApp.Repository;

import com.example.FirstJobApp.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
