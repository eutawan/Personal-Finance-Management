package br.com.cz.Model;

import java.util.UUID;

public class Renda extends TipoTransacao{
    private boolean forRecebido;

    public Renda(String instituicao, double valor, String metodoDePagamento, UUID idConta, UUID idUtilizador, boolean foiRecebido) {
        super(instituicao, valor, metodoDePagamento, idConta, idUtilizador);
        this.forRecebido = foiRecebido;
    }
}
