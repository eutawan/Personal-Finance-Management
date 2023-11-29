package br.com.cz.Controller;

import br.com.cz.Dao.ContaBancariaDAO;
import br.com.cz.Exception.ContaBancariaException;
import br.com.cz.Interface.IAutenticacaoController;
import br.com.cz.Interface.IContaBancariaController;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.ContaBancaria;

import java.util.ArrayList;

public class ContaBancariaController implements IContaBancariaController {
    private IDao<ContaBancaria> dao;

    public ContaBancariaController() {
        this.dao = new ContaBancariaDAO();
    }

    @Override
    public boolean adicionarConta(ContaBancaria contaBancaria) {
        try {
            if(contaBancaria != null) {
                return this.dao.adicionar(contaBancaria);
            } else {
                throw new ContaBancariaException();
            }
        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizarConta(String nomeInstituicao, ContaBancaria novaContaBancaria) {
        try {
            if (nomeInstituicao != null && novaContaBancaria != null) {
                return this.dao.atualizar(nomeInstituicao, novaContaBancaria);
            } else {
                throw new ContaBancariaException();
            }
        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerConta(ContaBancaria contaBancaria) {
        try {
            if (contaBancaria != null){
                return this.dao.remover(contaBancaria);
            }
        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerConta(String nomeInstituicao) {
        try {
            ContaBancaria cntBuscado = this.dao.buscar(nomeInstituicao);
            if (nomeInstituicao != null && cntBuscado != null){
                return this.dao.remover(cntBuscado);
            }
        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ContaBancaria buscarConta(String nomeInstituicao) {
        try {
            if (nomeInstituicao != null){
                ContaBancaria cntBuscado = this.dao.buscar(nomeInstituicao);
                return cntBuscado;

            }
        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<ContaBancaria> listarContas(){
        try {

        } catch (ContaBancariaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
