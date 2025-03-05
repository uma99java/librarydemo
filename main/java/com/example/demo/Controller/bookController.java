package com.example.demo.Controller;


import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.BookServiceImpl;
import com.example.demo.Service.CustomUserDetailsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class bookController implements bookCont {

    private final BookServiceImpl bookService;
    private final CustomUserDetailsService customUserDetailsService;

    public bookController(BookServiceImpl bookService, CustomUserDetailsService customUserDetailsService) {
        this.bookService = bookService;
        this.customUserDetailsService = customUserDetailsService;
    }

    // method to retrieve a book by provided id
    @GetMapping("/{num}")
    // <-- Теперь URL должен содержать число
    ResponseEntity<List<BookDTO>> getAllBooks(@PathVariable int num) {
        if (num <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            bookService.getBook(num);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // method to register new user in database
    @PostMapping("/register")
    ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        UserDTO result = customUserDetailsService.register(dto);
        return ResponseEntity.ok(result);

    }

    @PostMapping("/add")
    ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            bookService.addBook(bookDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}





