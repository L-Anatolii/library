package com.library.error;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long book_id){
        super("Книга не найден: " + book_id);
    }
}
