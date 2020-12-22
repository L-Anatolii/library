package com.library.controller;

import com.library.error.AuthorNotFoundException;
import com.library.error.BookNotFoundException;
import com.library.model.Author;
import com.library.model.Book;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8082")
@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books")
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    @GetMapping(value = "/authors")
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @GetMapping("/book/{book_id}")
    private Book getBook(@PathVariable("book_id") long book_id){
        return bookRepository.findById(book_id).orElseThrow(()->new BookNotFoundException(book_id));
    }

    @GetMapping("/author/{author_id")
    private Author getAuthor(@PathVariable("author_id") long author_id){
        return authorRepository.findById(author_id).orElseThrow(()->new AuthorNotFoundException(author_id));
    }

    @DeleteMapping("/book/{book_id}")
        private void deleteBook(@PathVariable("book_id") long book_id){
           bookRepository.deleteById(book_id);
    }

    @DeleteMapping("/author/{author_id}")
        private void deleteAuthor(@PathVariable("author_id") long author_id){
            authorRepository.deleteById(author_id);
        }

    @PostMapping("/books")
    private long saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return book.getBooks_id();
    }

    @PostMapping("/authors")
    private long saveAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return author.getAuthor_id();
    }
}
