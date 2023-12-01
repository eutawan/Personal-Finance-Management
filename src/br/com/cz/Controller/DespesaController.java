package br.com.cz.Controller;

import br.com.cz.Exception.DespesaException;
import br.com.cz.Interface.IDespesaController;
import br.com.cz.Model.Despesa;

import java.util.List;
import java.util.UUID;

public class DespesaController implements IDespesaController {
    @Override
    public boolean adicionarDespesa(Despesa despesa) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Despesa> listarDespesa() {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Despesa buscarDespesa(String idDaTransacao) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Despesa buscarDespesa(UUID idDaConta, String idDaTransacao) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean editarDespesa(String idDaTransacao, Despesa despesaNova) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerDespesa(String idDaDaTransacao) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerDespesa(Despesa despesa) {
        try{
            if () {

            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
