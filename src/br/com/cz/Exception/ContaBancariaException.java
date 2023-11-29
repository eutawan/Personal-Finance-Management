package br.com.cz.Exception;

public class ContaBancariaException extends RuntimeException {

    public ContaBancariaException() {
        super("ERROR -> Conta Bancaria Inexistente");
    }
}
