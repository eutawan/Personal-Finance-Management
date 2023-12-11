package br.com.cz.Exception;

public class NaoPagoException extends RuntimeException{
    public NaoPagoException() {
        super("ERROR -> A DESPESA NÃO FOI PAGA.");
    }
}
