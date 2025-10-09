package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesByNameFragment(String nameFragment) throws SearchProcessingException {
        validateInput(nameFragment);
        List<Company> companiesFound = companyDao.findByAnyCompanyNameLetters("%" + nameFragment + "%");
        checkIfCompanyListIsEmpty(companiesFound);
        return companiesFound;
    }

    public List<Employee> findEmployeesByNameFragment(String nameFragment)  throws SearchProcessingException {
        validateInput(nameFragment);
        List<Employee> employeesFound = employeeDao.findByAnyEmployeeNameLetters("%" + nameFragment + "%");
        checkIfEmployeeListIsEmpty(employeesFound);
        return employeesFound;
    }

    private void validateInput(String input) throws SearchProcessingException {
        if (input == null) {
            throw new SearchProcessingException(SearchProcessingException.ERR_WRONG_INPUT);
        }
        if (input.isEmpty()) {
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPTY_INPUT);
        }
    }

    private void checkIfCompanyListIsEmpty(List<Company> companiesFound) throws SearchProcessingException {
        if (companiesFound.isEmpty()) {
            throw new SearchProcessingException(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
        }
    }

    private void checkIfEmployeeListIsEmpty(List<Employee> employeesFound) throws SearchProcessingException {
        if (employeesFound.isEmpty()) {
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        }
    }
}
