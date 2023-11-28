package br.com.cz.Exception;

public class SenhaIncorretaException extends RuntimeException{

    public SenhaIncorretaException() {
        super("ERROR -> Senha incorreta");
    }
}
