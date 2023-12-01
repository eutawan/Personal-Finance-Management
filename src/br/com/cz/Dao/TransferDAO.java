package br.com.cz.Dao;

import br.com.cz.Interface.IDao;
import br.com.cz.Model.Despesa;
import br.com.cz.Model.Transferencia;

import java.util.ArrayList;
import java.util.List;

public class TransferDAO implements IDao<Transferencia> {
    private ArrayList<Transferencia> transferencias;

    public TransferDAO() {
        this.transferencias = new ArrayList<>();
    }

    @Override
    public boolean adicionar(Transferencia objeto) {
        try {
            return this.transferencias.add(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Transferencia objeto) {
        try {
            return this.transferencias.remove(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, Transferencia transferNova) {
        try {
            for (int i = 0; i < transferencias.size(); i++) {
                if (transferencias.get(i).getIdTransacao().equals(identificador)) {
                    transferencias.set(i, transferNova);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Transferencia buscar(String identificador) {
        try {
            for (Transferencia trn: transferencias) {
                if (trn.getIdTransacao().equals(identificador)) {
                    return trn;
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Transferencia> listar() {
        try {
            return transferencias;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
