package br.com.erick.spring_boot_essentials.exeption;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
