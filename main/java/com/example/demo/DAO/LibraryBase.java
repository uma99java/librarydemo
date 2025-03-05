package com.example.demo.DAO;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LibraryBase implements LibBase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        getBook(1);

    }


    @Override
    public void addUser(UserDTO user) {
        System.out.println("method addUser() called");
        try {
            String sql = "insert into foydalanuvchi (name, surname, number,balance) values (?, ?, ?,?)";

            jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getNumber(), user.getBalance());
        } catch (Exception e) {
            System.out.println("error inserting user" + e.getMessage());
        }


    }


    @Override
    public void addBook(BookDTO book) {
        try {
            String sql = "INSERT INTO kitob (name, author)values(?, ?)";
            jdbcTemplate.update(sql, book.getName(), book.getAuthor());
        } catch (Exception e) {
            System.out.println("Error in adding book" + e.getMessage());
        }


    }

    @Override
    // method to get the book which id will be provided in order to retrieve an exact book
    public BookDTO getBook(int id) {
        try {
            String sql = "SELECT * FROM kitob WHERE id = ?";
            BookDTO book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookDTO.class), id);
            System.out.println(book);  // Для отладки можно оставить
            return book;  // Нужно вернуть book

        } catch (Exception e) {
            System.out.println("Error in getting book: " + e.getMessage());
        }
        return null;  // Если произошла ошибка, возвращаем null
    }


}
