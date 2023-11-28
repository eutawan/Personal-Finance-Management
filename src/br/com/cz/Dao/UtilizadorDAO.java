package br.com.cz.Dao;

import br.com.cz.Exception.UtilizadorException;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.Pessoa;
import br.com.cz.Model.Utilizador;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UtilizadorDAO implements IDao<Utilizador<? extends Pessoa>> {
    private ArrayList<Utilizador<? extends Pessoa>> utilizadores;

    public UtilizadorDAO() {
        this.utilizadores = new ArrayList<>();
    }


    @Override
    public boolean adicionar(Utilizador<? extends Pessoa> utilizador) {
        try {
            return this.utilizadores.add(utilizador);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Utilizador<? extends Pessoa> utilizador) {
        try {
            return this.utilizadores.remove(utilizador);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String nomeDoUsuario, Utilizador<? extends Pessoa> utilizadorNovo) {
        try {
            for(int i = 0; i < utilizadores.size(); i++) {
                if (utilizadores.get(i).getNomeUsuario().equals(nomeDoUsuario)) {
                    this.utilizadores.set(i, utilizadorNovo);
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Utilizador<? extends Pessoa> buscar(String nomeDoUsuario) {
        try {
            for (Utilizador<? extends Pessoa> utl: utilizadores) {
                if (utl.getNomeUsuario().equals(nomeDoUsuario)) {
                    return utl;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Utilizador<? extends Pessoa>> listar() {
        try {
            return utilizadores;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
