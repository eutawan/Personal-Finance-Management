package br.com.cz.Exception;

public class IdadeInvalidaException extends RuntimeException{
    public IdadeInvalidaException() {
        super("ERROR -> NÃO É POSSÍVEL CRIAR CONTA PARA MENORES DE DEZESSEIS ANOS.");
    }
}
