package br.com.cz.Interface;

import br.com.cz.Model.Despesa;
import br.com.cz.Model.Transferencia;

import java.util.List;
import java.util.UUID;

public interface IDespesaController {

    boolean adicionarDespesa(Despesa despesa);

    List<Despesa> listarDespesa();

    Despesa buscarDespesa(String idDaTransacao);

    Despesa buscarDespesa(UUID idDaConta, String idDaTransacao);

    boolean editarDespesa(String idDaTransacao, Despesa despesaNova);

    boolean removerDespesa(String idDaDaTransacao);

    boolean removerDespesa(Despesa despesa);
}
