package br.com.phricardo.mockecomm.exceptions;

import java.time.LocalDateTime;

public record ErrorPayload(String message, LocalDateTime timestamp) {}
