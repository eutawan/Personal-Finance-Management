package br.com.cz.Interface;

import br.com.cz.Model.Despesa;
import br.com.cz.Model.Transferencia;

import java.util.List;
import java.util.UUID;

public interface IDespesaController {

    boolean adicionarDespesa(Despesa despesa);

    List<Despesa> listarDespesa(UUID idUtilizador);

    Despesa buscarDespesa(String idDaTransacao);

    List<Despesa> buscarDespesas(UUID idDaConta, String idUtilizador);

    boolean editarDespesa(String idDaTransacao, Despesa despesaNova);

    boolean removerDespesa(String idDaDaTransacao);

    boolean removerDespesa(Despesa despesa);
}
