package br.com.cz.Exception;

public class IdadeInvalidaException extends RuntimeException{
    public IdadeInvalidaException() {
        super("ERROR -> Menores de 16 anos sem permissao para criar conta");
    }
}
