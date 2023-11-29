package br.com.cz.Interface;

import br.com.cz.Model.ContaBancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IContaBancariaController {

    boolean adicionarConta(ContaBancaria contaBancaria);
    boolean atualizarConta(String nomeInstituicao, ContaBancaria novaContaBancaria);
    boolean removerConta(ContaBancaria contaBancaria);
    boolean removerConta(String nomeInstituicao);
    ContaBancaria buscarConta(String nomeInstituicao);
    List<ContaBancaria> listarContas(UUID idDoUtilizador);
}
