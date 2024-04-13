package br.com.phricardo.mockecomm.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException() {
    super("Resource not found.");
  }

  public NotFoundException(final String message) {
    super(message);
  }
}
