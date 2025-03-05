package com.example.demo.DTO;

public class LibrarianDTO {
    private String name;
    private String surname;
    private String role;
    private String number;
    private String password;

    public LibrarianDTO() {

    }

    public LibrarianDTO(String name, String surname, String role, String number, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.number = number;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
