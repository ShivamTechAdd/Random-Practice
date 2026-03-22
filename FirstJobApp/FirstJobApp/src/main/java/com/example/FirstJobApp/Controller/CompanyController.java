package com.example.FirstJobApp.Controller;

import com.example.FirstJobApp.Model.Company;
import com.example.FirstJobApp.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllComapany() , HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updateCompany(@RequestBody Company company , @PathVariable Long id){
        boolean isUpadated = companyService.updateCompany(company,id);
        return isUpadated ? new ResponseEntity<>("Company is updated succesfully" , HttpStatus.OK)
            :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company is create successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompany(id);
        return isDeleted ? new ResponseEntity<>("Company deleted sucsesfully" , HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getComapnyById(id);
        return company !=null ? new ResponseEntity<>( company, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
