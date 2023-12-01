package br.com.cz.Interface;

import br.com.cz.Model.Transferencia;

import java.util.List;
import java.util.UUID;

public interface ITransferController {

    boolean adicionarTransfer(Transferencia transferencia);

    List<Transferencia> listarTransfers();

    Transferencia buscarTransfer(String idDaTransacao);

    Transferencia buscarTransfer(UUID idDaConta, String idDaTransacao);

    boolean editarTransfer(String idDaTransacao, Transferencia transferNova);

    boolean removerTransfer(String idDaDaTransacao);

    boolean removerTransfer(Transferencia transferencia);
}
