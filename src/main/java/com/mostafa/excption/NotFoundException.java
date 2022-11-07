package com.mostafa.excption;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.excption.NotFoundException.java: SpringBootSecurity-JWT
 * @CreationDate 10/24/2022 2:05 PM
 */
public class NotFoundException extends Exception {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
