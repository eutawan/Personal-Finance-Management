package br.com.cz.Exception;

import br.com.cz.Interface.IDao;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException() {
        super("ERROR -> Id não encontrado");
    }
}
