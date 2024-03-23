package br.com.rmsa.benchmark.exception;

public class FileProccessorException extends Exception {

    public FileProccessorException(String message, Exception e) {
        super(message, e);
    }
}
