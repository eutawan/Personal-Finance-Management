package br.com.cz.Exception;

public class DespesaException extends RuntimeException{
    public DespesaException() {
        super("ERROR -> Despesa Inexistente");
    }
}
