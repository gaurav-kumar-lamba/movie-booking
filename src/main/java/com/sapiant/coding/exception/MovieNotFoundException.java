package com.sapiant.coding.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movie_id, String msg) {
    }
}
