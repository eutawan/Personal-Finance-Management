package br.com.cz.Controller;

import br.com.cz.Interface.IAutenticacaoController;
import br.com.cz.Interface.IContaBancariaController;
import br.com.cz.Model.ContaBancaria;

public class ContaBancariaController implements IContaBancariaController {


    @Override
    public boolean adicionarConta(ContaBancaria contaBancaria) {
        return false;
    }

    @Override
    public boolean atualizarConta(String nomeInstituicao, ContaBancaria novaContaBancaria) {
        return false;
    }

    @Override
    public boolean removerConta(ContaBancaria contaBancaria) {
        return false;
    }

    @Override
    public boolean removerConta(String nomeInstituicao) {
        return false;
    }

    @Override
    public ContaBancaria buscarConta(String nomeInstituicao) {
        return null;
    }

    @Override
    public ContaBancaria buscarConta(ContaBancaria contaBancaria) {
        return null;
    }
}
