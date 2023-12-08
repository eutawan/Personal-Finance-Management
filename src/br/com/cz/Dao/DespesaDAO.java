package br.com.cz.Dao;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.Despesa;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO implements IDao<Despesa> {
    private ArrayList<Despesa> despesas;

    public DespesaDAO() {
        this.despesas = new ArrayList<>();
    }

    @Override
    public boolean adicionar(Despesa objeto) {
        try {
            return this.despesas.add(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Despesa objeto) {
        try {
            return this.despesas.remove(objeto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, Despesa despesaNova) {
        try {
            for (int i = 0; i < despesas.size(); i++) {
                if (despesas.get(i).getIdTransacao().equals(identificador)){
                    despesas.set(i, despesaNova);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Despesa buscar(String identificador) {
        try {
            for (Despesa dsp: despesas) {
                if (dsp.getIdTransacao().equals(identificador)) {
                    return dsp;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Despesa> listar() {
        try {
            return despesas;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
