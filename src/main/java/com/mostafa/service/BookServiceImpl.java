package com.mostafa.service;

import com.mostafa.entity.Book;
import com.mostafa.excption.NotFoundException;
import com.mostafa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.service.BookServiceImpl.java: SpringBootSecurity-JWT
 * @CreationDate 10/2/2022 12:39 PM
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() throws NotFoundException {
        List<Book> bookList = bookRepository.findAll();

        if (bookList.size() == 0) {
            throw new NotFoundException("No Book Found. Please add first.");
        }
        return bookList;
    }

    @Override
    public Book findBookById(long id) throws NotFoundException {
        Optional<Book> book = bookRepository.findById(id);

        if (!book.isPresent()) {
            throw new NotFoundException("No book found with given book id: "+id);
        }

        return book.get();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) throws NotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());

        if (!optionalBook.isPresent()) {
            throw new NotFoundException("Provided Book not found in storage. Modified nothing.");
        }

        return bookRepository.save(book);
    }

    @Override
    public String deleteBook(Book book) throws NotFoundException {
        bookRepository.findById(book.getId()).orElseThrow(
                () -> new NotFoundException("Provided Book not found in storage. Deleted nothing.")
        );

        bookRepository.delete(book);

        return "Deleted Successfully!";
    }
}
