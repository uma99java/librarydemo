package com.example.demo.DAO;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;


public interface LibBase {
    // for librarian to add a new user
    void addUser(UserDTO user);


    // for librarian to add new books
    void addBook(BookDTO book);



    // for user to get a book
    BookDTO getBook(int id);



}
