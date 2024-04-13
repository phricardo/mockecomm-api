package br.com.phricardo.mockecomm.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  private static final String CONTENT_TYPE = "Content-Type";
  private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

  @ExceptionHandler(NotFoundException.class)
  public HttpEntity<?> handleNotFoundException(final NotFoundException ex) {
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    return new ResponseEntity<>(createErrorPayload(ex), responseHeaders, NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public HttpEntity<?> handleGenericException(final Exception ex) {
    log.debug("An internal server error occurred", ex);
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    return new ResponseEntity<>(createErrorPayload(ex), responseHeaders, INTERNAL_SERVER_ERROR);
  }

  private ErrorPayload createErrorPayload(final Exception ex) {
    return new ErrorPayload(ex.getLocalizedMessage(), LocalDateTime.now());
  }
}
