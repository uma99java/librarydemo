package com.example.demo.Service;


import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookServ {

    void addBook(BookDTO book);

    BookDTO getBook(int num);


}
