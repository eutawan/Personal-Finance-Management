package br.com.cz.Exception;

public class LimiteDespesaException extends RuntimeException{
    public LimiteDespesaException() {
        super("ERROR -> Valor da despesa excede o saldo da conta");
    }
}
