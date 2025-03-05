package com.example.demo.DTO;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String role;
    private String number;
    private int balance;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, String role, String number, int balance, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.number = number;
        this.balance = balance;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public String getNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getPassword() {
        return this.password;
    }


}
