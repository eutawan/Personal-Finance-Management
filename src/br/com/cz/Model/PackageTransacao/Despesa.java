package br.com.cz.Model.PackageTransacao;

import java.util.UUID;

public class Despesa extends TipoTransacao {
    private boolean foiPago;

    public Despesa(String instituicao, double valor, String metodoDePagamento, UUID idConta, UUID idUtilizador, boolean foiPago) {
        super(instituicao, valor, metodoDePagamento, idConta, idUtilizador);
        this.foiPago = foiPago;
    }

    public boolean isFoiPago() {
        return foiPago;
    }

    public void setFoiPago(boolean foiPago) {
        this.foiPago = foiPago;
    }
}
