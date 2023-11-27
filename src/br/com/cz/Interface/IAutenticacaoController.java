package br.com.cz.Interface;


import java.util.UUID;

public interface IAutenticacaoController {

    boolean cadastro();
    boolean login();
    void excluirConta();
}
