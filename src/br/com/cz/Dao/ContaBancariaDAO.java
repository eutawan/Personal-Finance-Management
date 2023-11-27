package br.com.cz.Dao;

import br.com.cz.Interface.IDao;
import br.com.cz.Model.ContaBancaria;

import java.util.List;

public class ContaBancariaDAO implements IDao<ContaBancaria> {
    @Override
    public boolean adicionar(ContaBancaria objeto) {
        return false;
    }

    @Override
    public boolean remover(ContaBancaria objeto) {
        return false;
    }

    @Override
    public boolean atualizar(ContaBancaria objeto) {
        return false;
    }

    @Override
    public ContaBancaria buscar(String Identificador) {
        return null;
    }

    @Override
    public List<ContaBancaria> listar() {
        return null;
    }
}
