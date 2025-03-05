package com.example.demo.Service;

import com.example.demo.DAO.LibraryBase;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServ {

    private final LibraryBase libraryBase;



    public BookServiceImpl(LibraryBase libraryBase) {
        this.libraryBase = libraryBase;
    }


    @Override
    public void addBook(BookDTO book) {
        BookDTO kitob = new BookDTO();
        if (book.getAuthor() == kitob.getAuthor() || book.getName() == kitob.getName()) {
            libraryBase.addBook(book);

        }

    }

    @Override
    public BookDTO getBook(int num) {
        if (num != 0) {
            return libraryBase.getBook(num);

        }
        return null;

    }
}
