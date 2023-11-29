package br.com.cz.Exception;

public class RendaException extends RuntimeException{
    public RendaException() {
        super("ERROR -> Renda inexistente");
    }
}
