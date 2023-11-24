package br.com.cz.Exception;

public class UtilizadorException extends RuntimeException{
    public UtilizadorException() {
        super("Utilizador não existe");
    }
}
