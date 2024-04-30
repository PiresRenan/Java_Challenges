package org.example.leitor_csv.leitor;

public class CSVException extends Exception {
    public CSVException(String message) {
        super(message);
    }

    public CSVException(String message, Throwable cause) {
        super(message, cause);
    }
}
