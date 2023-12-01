package br.com.cz.Dao;

import br.com.cz.Interface.IDao;
import br.com.cz.Model.Despesa;
import br.com.cz.Model.Renda;

import java.util.ArrayList;
import java.util.List;

public class RendaDAO implements IDao<Renda> {
    private ArrayList<Renda> rendas;

    public RendaDAO() {
        this.rendas = new ArrayList<>();
    }
    @Override
    public boolean adicionar(Renda objeto) {
        try {
            return this.rendas.add(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Renda objeto) {
        try {
            return this.rendas.remove(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, Renda rendaNova) {
        try {
            for (int i = 0; i < rendas.size(); i++) {
                if (rendas.get(i).getIdTransacao().equals(identificador)) {
                    rendas.set(i, rendaNova);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Renda buscar(String identificador) {
        try {
            for (Renda rnd: rendas) {
                if (rnd.getIdTransacao().equals(identificador)) {
                    return rnd;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Renda> listar() {try {
        return rendas;
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }

        return null;
    }
}
