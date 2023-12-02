package br.com.cz.Interface;

import br.com.cz.Model.Transferencia;

import java.util.List;
import java.util.UUID;

public interface ITransferController {

    boolean adicionarTransfer(Transferencia transferencia);

    List<Transferencia> listarTransfers(UUID idUtilizaodr);

    Transferencia buscarTransfer(String idDaTransacao);

    List<Transferencia> buscarTransfer(UUID idDaConta, UUID idUtilizador);

    boolean editarTransfer(String idDaTransacao, Transferencia transferNova);

    boolean removerTransfer(String idDaDaTransacao);

    boolean removerTransfer(Transferencia transferencia);
}
