package br.com.cz.Model;

import java.util.UUID;

public class Transferencia extends TipoTransacao{

    private String insituicaoDestino;

    public Transferencia(String instituicao, double valor, String metodoDePagamento, UUID idConta, UUID idUtilizador, String insituicaoDestino) {
        super(instituicao, valor, metodoDePagamento, idConta, idUtilizador);
        this.insituicaoDestino = insituicaoDestino;
    }
}
