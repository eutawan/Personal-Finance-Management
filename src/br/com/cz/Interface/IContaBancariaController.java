package br.com.cz.Interface;

import br.com.cz.Model.ContaBancaria;

public interface IContaBancariaController {

    boolean adicionarConta(ContaBancaria contaBancaria);
    boolean atualizarConta(String nomeInstituicao, ContaBancaria novaContaBancaria);
    boolean removerConta(ContaBancaria contaBancaria);
    boolean removerConta(String nomeInstituicao);
    ContaBancaria buscarConta(String nomeInstituicao);
    ContaBancaria buscarConta(ContaBancaria contaBancaria);
}
