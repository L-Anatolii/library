package com.library.error;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(long author_id){
        super("Автор не найден: " + author_id);
    }
}