package br.com.cz.Exception;

public class InvestimentoException extends RuntimeException{
    public InvestimentoException(){
        super("ERROR -> Investimento Inexistente");
    }
}
