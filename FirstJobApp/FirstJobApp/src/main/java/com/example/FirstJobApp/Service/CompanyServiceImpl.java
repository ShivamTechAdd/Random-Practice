package com.example.FirstJobApp.Service;

import com.example.FirstJobApp.Model.Company;
import com.example.FirstJobApp.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllComapany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company , Long id) {
        Company savedCompany = companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No company exists with this id "+id));

        savedCompany.setName(company.getName());
        savedCompany.setDescription(company.getDescription());
        savedCompany.setJobs(company.getJobs());
        Company updatedCompany = companyRepository.save(savedCompany);
        return true;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getComapnyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No company exists with this id "+id));
    }
}
