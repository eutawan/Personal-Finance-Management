package br.com.cz.Model.PackageInvestimento;

import java.time.LocalDate;

public abstract class TipoInvestimento {
    LocalDate dataDeCompra;
    int qntInvestida;
    double cotacao;
    String ativo;
    String instituicaoFinanceira;

    public TipoInvestimento(LocalDate dataDeCompra, int qntInvestida, double cotacao, String ativo,
                            String instituicaoFinanceira){
        this.qntInvestida = qntInvestida;
        this.cotacao = cotacao;
        this.ativo = ativo;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public LocalDate getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(LocalDate dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public int getQntInvestida() {
        return qntInvestida;
    }

    public void setQntInvestida(int qntInvestida) {
        this.qntInvestida = qntInvestida;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
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
