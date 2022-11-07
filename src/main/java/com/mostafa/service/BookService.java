package com.mostafa.service;

import com.mostafa.entity.Book;
import com.mostafa.excption.NotFoundException;

import java.util.List;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.BookService.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:36 PM
 */
public interface BookService {
    List<Book> findAllBooks() throws NotFoundException;
    Book findBookById(long id) throws NotFoundException;
    Book saveBook(Book book);
    Book updateBook(Book book) throws NotFoundException;
    String deleteBook(Book book) throws NotFoundException;
}
