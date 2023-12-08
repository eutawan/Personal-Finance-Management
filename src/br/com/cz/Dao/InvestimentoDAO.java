package br.com.cz.Dao;
import br.com.cz.Exception.InvestimentoException;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.PackageInvestimento.Investimento;
import br.com.cz.Model.PackageInvestimento.TipoInvestimento;
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
            this.investimentos.add(objeto);
            
        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Investimento<? extends TipoInvestimento> objeto) {
        try {
            this.investimentos.remove(objeto);
        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(String identificador, Investimento<? extends TipoInvestimento> objeto) {
        try {
            for (int i = 0; i < investimentos.size(); i++) {
                if (investimentos.get(i).getIdInvestimento().equals(identificador)){
                    investimentos.set(i, objeto);
                }
            }
        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Investimento<? extends TipoInvestimento> buscar(String identificador) {
        try {
            for (Investimento<? extends TipoInvestimento> invest : investimentos
                 ) {
                if (invest.getIdInvestimento().equals(identificador)){
                    return invest;
                }
            }
        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Investimento<? extends TipoInvestimento>> listar() {
        try {
            return investimentos;

        }catch (InvestimentoException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
