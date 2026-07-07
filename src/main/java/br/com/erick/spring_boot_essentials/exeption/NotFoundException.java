package br.com.erick.spring_boot_essentials.exeption;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
