package br.com.cz.Dao;
import br.com.cz.Exception.InvestimentoException;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.Investimento;
import br.com.cz.Model.TipoInvestimento;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO implements IDao<Investimento<? extends TipoInvestimento>> {

    private ArrayList<Investimento<? extends TipoInvestimento>> investimentos;

    public InvestimentoDAO(){
        this.investimentos = new ArrayList<>();
    }

    @Override
    public boolean adicionar(Investimento<? extends TipoInvestimento> objeto) {
        try {

        }catch (InvestimentoException e){
            System.err.println(e);
        }
        return false;
    }

    @Override
    public boolean remover(Investimento<? extends TipoInvestimento> objeto) {
        try {

        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, Investimento<? extends TipoInvestimento> objeto) {
        try {

        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Investimento<? extends TipoInvestimento> buscar(String identificador) {
        try {

        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Investimento<? extends TipoInvestimento>> listar() {
        try {

        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
