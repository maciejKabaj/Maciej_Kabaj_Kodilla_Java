package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private SearchFacade searchFacade;

    @BeforeEach
    public void setup() {
        employeeDao.save(new Employee("John", "Krasinski"));
        employeeDao.save(new Employee("Emily", "Blunt"));
        employeeDao.save(new Employee("Tom", "Holland"));
        employeeDao.save(new Employee("Will", "Smith"));
        employeeDao.save(new Employee("Jane", "Doe"));

        companyDao.save(new Company("General Motors"));
        companyDao.save(new Company("Facebook"));
        companyDao.save(new Company("Google"));
        companyDao.save(new Company("Dropbox"));
        companyDao.save(new Company("Groupon"));
    }

    @AfterEach
    public void tearDown() {
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }

    @Test
    void shouldFindCompaniesByNameFragment() throws SearchProcessingException {
        //When
        List<Company> companiesFound = searchFacade.findCompaniesByNameFragment("ace");
        //Then
        assertEquals(1, companiesFound.size());
    }

    @Test
    void shouldFindEmployeesByNameFragment() throws SearchProcessingException {
        //When
        List<Employee> employeesFound = searchFacade.findEmployeesByNameFragment("ll");
        //Then
        assertEquals(2, employeesFound.size());
    }

    @Test
    void shouldThrowExceptionWhenNoCompanies() {
        //Then
        Exception exception = assertThrows(SearchProcessingException.class, () -> {
            searchFacade.findCompaniesByNameFragment("xyz");
        });
        assertEquals("Company not found!", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoEmployees() {
        //Then
        Exception exception = assertThrows(SearchProcessingException.class, () -> {
            searchFacade.findEmployeesByNameFragment("xyz");
        });
        assertEquals("Employee not found!", exception.getMessage());
    }
}
