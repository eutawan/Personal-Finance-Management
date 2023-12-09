package br.com.cz.Model.PackageInvestimento;

import java.time.LocalDate;

public abstract class TipoInvestimento {
    LocalDate dataDeCompra;
    double valorInvestimento;
    String ativo;
    String instituicaoFinanceira;

    public TipoInvestimento(LocalDate dataDeCompra, int qntInvestida, double cotacao, String ativo,
                            String instituicaoFinanceira){
        this.valorInvestimento = qntInvestida * cotacao;
        this.ativo = ativo;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public LocalDate getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(LocalDate dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }
    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }
}
