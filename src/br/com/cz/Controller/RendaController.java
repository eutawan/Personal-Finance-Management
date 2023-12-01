package br.com.cz.Controller;

import br.com.cz.Exception.RendaException;
import br.com.cz.Interface.IRendaController;
import br.com.cz.Model.Renda;

import java.util.List;
import java.util.UUID;

public class RendaController implements IRendaController {
    @Override
    public boolean adicionarRenda(Renda renda) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizarRenda(String idDaTransacao, Renda renda) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerRenda(Renda renda) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerRenda(String idDaTransacao) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Renda buscarRenda(String idDaTransacao) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Renda buscarRenda(UUID idDaConta, String idDaTransacao) {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Renda> listarRendas() {
        try {
            if () {

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
