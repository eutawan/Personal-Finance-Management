package br.com.cz.Model;

import java.util.UUID;

public class Transferencia extends TipoTransacao{

    private String instituicaoDestino;
    private UUID idContaDestino;


    public Transferencia(String instituicao, double valor, String metodoDePagamento, UUID idConta, UUID idUtilizador, String instituicaoDestino,
                         UUID idContaDestino) {
        super(instituicao, valor, metodoDePagamento, idConta, idUtilizador);
        this.instituicaoDestino = instituicaoDestino;
        this.idContaDestino = idContaDestino;
    }
}
