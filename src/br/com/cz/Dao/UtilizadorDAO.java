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
            if (utilizador != null) {
                return this.utilizadores.add(utilizador);
            } else {
                throw new UtilizadorException("Utilizador inexistente");
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Utilizador<? extends Pessoa> utilizador) {
        try {
            if (utilizador != null) {
                return this.utilizadores.remove(utilizador);
            } else {
                throw new UtilizadorException("O utilizador pesquisado inexistente");
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Utilizador<? extends Pessoa> utilizador) {
        try {
            if (utilizador != null) {
                for(int i = 0; i < utilizadores.size(); i++)
                    if (utilizadores.get(i).equals(utilizador)) {
                        this.utilizadores.set(i, utilizador);
                        return true;
                    }
            } else {
                throw new UtilizadorException("Utilizador novo inexistente");
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Utilizador<? extends Pessoa> buscar(String nomeDoUsuario) {
        try {
            if (nomeDoUsuario != null) {
                for (Utilizador<? extends Pessoa> utl: utilizadores) {
                    if (utl.getNomeUsuario().equals(nomeDoUsuario)) {
                        return utl;
                    }
                }
            } else {
                throw new UtilizadorException("ID do utilizador não corresponde");
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Utilizador<? extends Pessoa>> listar() {
        try {
            if (utilizadores != null) {
                return utilizadores;
            } else {
                throw new UtilizadorException("Nenhum Utilizador Cadastrado");
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
