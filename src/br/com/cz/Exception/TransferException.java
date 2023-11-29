package br.com.cz.Exception;

public class TransferException extends RuntimeException{
    public TransferException() {
        super("ERROR -> transferencia inexistente");
    }
}
