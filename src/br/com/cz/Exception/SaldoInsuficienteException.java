package br.com.cz.Exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(){
        super("ERROR -> SALDO INSUFICIENTE.");
    }
}
