package com.kodilla.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception {

    public static final String ERR_WRONG_INPUT = "Wrong input!";
    public static final String ERR_EMPTY_INPUT = "Empty input!";
    public static final String ERR_COMPANY_NOT_FOUND = "Company not found!";
    public static final String ERR_EMPLOYEE_NOT_FOUND = "Employee not found!";

    public SearchProcessingException(String message) {
        super(message);
    }
}
