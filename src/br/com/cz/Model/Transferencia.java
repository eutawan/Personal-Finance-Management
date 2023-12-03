package br.com.cz.Model;

import java.util.UUID;

public class Transferencia extends TipoTransacao{

    private String insituicaoDestino;
    private UUID contaDestino;

    public Transferencia(String instituicao, double valor, String metodoDePagamento, UUID idConta, UUID idUtilizador, String insituicaoDestino,
                         UUID idContaDestino) {
        super(instituicao, valor, metodoDePagamento, idConta, idUtilizador);
        this.insituicaoDestino = insituicaoDestino;
        this.contaDestino = idContaDestino;
    }
}
