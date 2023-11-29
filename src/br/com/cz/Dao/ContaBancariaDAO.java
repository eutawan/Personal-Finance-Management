package br.com.cz.Dao;

import br.com.cz.Interface.IDao;
import br.com.cz.Model.ContaBancaria;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class ContaBancariaDAO implements IDao<ContaBancaria> {

    private final ArrayList<ContaBancaria> contasBancarias;

    public ContaBancariaDAO() {
        this.contasBancarias = new ArrayList<>();
    }

    @Override
    public boolean adicionar(ContaBancaria contaBancaria) {
        try {
            return this.contasBancarias.add(contaBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(ContaBancaria contaBancaria) {
        try {
            return this.contasBancarias.remove(contaBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, ContaBancaria contaBancariaNova) {
        try {
            for (int i = 0; i < contasBancarias.size(); i++) {
                if (contasBancarias.get(i).getInstituicao().equals(identificador)){
                    contasBancarias.set(i, contaBancariaNova);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ContaBancaria buscar(String identificador) {
        try {
            for (ContaBancaria cnt : contasBancarias) {
                if (cnt.getInstituicao().equals(identificador)){
                    return cnt;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ContaBancaria> listar() {
        try {
            return contasBancarias;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
