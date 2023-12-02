package br.com.cz.Model;

import java.util.UUID;

public class ContaBancaria {
    private UUID idConta;
    private UUID idUtilizador;
    private String instituicao;
    private double saldoConta;

    public ContaBancaria(String instituicao, double saldoConta, UUID idUtilizador){
        this.instituicao = instituicao;
        this.saldoConta = saldoConta;
        this.idUtilizador = idUtilizador;
        this.idConta = UUID.randomUUID();
    }

    public UUID getIdConta() {
        return idConta;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public double setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
        return saldoConta;
    }

    public UUID getIdUtilizador() {
        return idUtilizador;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "idConta=" + idConta +
                ", instituicao='" + instituicao + '\'' +
                ", saldoConta=" + saldoConta +
                '}';
    }
}
