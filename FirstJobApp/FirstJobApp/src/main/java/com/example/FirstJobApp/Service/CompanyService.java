package com.example.FirstJobApp.Service;

import com.example.FirstJobApp.Model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllComapany();

    boolean updateCompany(Company company , Long id);

    void createCompany(Company company);

    boolean deleteCompany(Long id);

    Company getComapnyById(Long id);
}
