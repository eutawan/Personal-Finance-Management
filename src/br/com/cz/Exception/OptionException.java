package br.com.cz.Exception;

public class OptionException extends RuntimeException{
    public OptionException() {
        super("ERROR -> Opção Inválida");
    }
}

