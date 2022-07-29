package org.gs.exception;

public class UrlShortenerException extends RuntimeException {

    public UrlShortenerException() {
    }

    public UrlShortenerException(String message) {
        super(message);
    }

    public UrlShortenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlShortenerException(Throwable cause) {
        super(cause);
    }

    public UrlShortenerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
