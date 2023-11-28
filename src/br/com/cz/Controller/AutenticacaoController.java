package br.com.cz.Controller;

import br.com.cz.Dao.UtilizadorDAO;
import br.com.cz.Exception.UtilizadorException;
import br.com.cz.Interface.IAutenticacaoController;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.Pessoa;
import br.com.cz.Model.Pessoal;
import br.com.cz.Model.Profissional;
import br.com.cz.Model.Utilizador;

import java.util.Scanner;

public class AutenticacaoController implements IAutenticacaoController {
    private IDao<Utilizador<? extends Pessoa>> dao;

    public AutenticacaoController() {
        this.dao = new UtilizadorDAO();
    }

    @Override
    public boolean adicionarUtilizador(Utilizador<? extends Pessoa> utl) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirUtilizador(Utilizador<? extends Pessoa> utl) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirUtilizador(String nomeDeUsuario, String senha) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean buscarUtilizador(Utilizador<? extends Pessoa> utl) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean buscarUtilizador(String nomeDeUsuario) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizarUtilizador(String nomeDeUsuario, String senha, Utilizador<? extends Pessoa> utl) {
        try {

        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
