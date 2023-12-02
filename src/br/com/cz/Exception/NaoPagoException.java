package br.com.cz.Exception;

public class NaoPagoException extends RuntimeException{
    public NaoPagoException() {
        super("ERROR -> Não foi paga a despesa");
    }
}
