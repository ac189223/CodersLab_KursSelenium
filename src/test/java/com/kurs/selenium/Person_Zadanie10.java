package com.kurs.selenium;

public class Person_Zadanie10 {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String email;
    private String password;
    private String company;
    private String comment;

    public Person_Zadanie10() {
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = "";
        this.address = "";
        this.email = "";
        this.password = "";
        this.company = "";
        this.comment = "";
    }

    public Person_Zadanie10(String firstName, String lastName, String dateOfBirth, String address, String email, String password, String company, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.password = password;
        this.company = company;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
