package br.com.cz.Model;

import java.util.UUID;

public class Despesa extends TipoTransacao{
    private boolean foiPago;

    public Despesa(String instituicao, double valor, String metodoDePagamento, UUID idConta, boolean foiPago) {
        super(instituicao, valor, metodoDePagamento, idConta);
        this.foiPago = foiPago;
    }
}
