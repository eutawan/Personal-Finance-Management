package br.com.cz.Model;

import java.util.UUID;

public class Renda extends TipoTransacao{
    private boolean forRecebido;

    public Renda(String instituicao, double valor, String metodoDePagamento, UUID idConta, boolean foiRecebido) {
        super(instituicao, valor, metodoDePagamento, idConta);
        this.forRecebido = foiRecebido;
    }
}
