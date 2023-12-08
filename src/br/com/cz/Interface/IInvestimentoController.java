package br.com.cz.Interface;
import br.com.cz.Model.PackageInvestimento.Investimento;
import br.com.cz.Model.PackageInvestimento.TipoInvestimento;

import java.util.List;

public interface IInvestimentoController {
    boolean adicionarInvestimento(Investimento<? extends TipoInvestimento> utl);
    boolean excluirInvestimento(Investimento<? extends TipoInvestimento> utl);
    boolean excluirInvestimento(String idInvest);
    Investimento<? extends TipoInvestimento> buscarInvestimento(String idInvest);
    boolean atualizarInvestimento(String idInvest, Investimento<? extends TipoInvestimento> investNew);

    List<Investimento<? extends TipoInvestimento>> listarInvestimentos(String idUtilizador);

}
