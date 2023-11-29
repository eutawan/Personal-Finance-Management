package br.com.cz.Model;

import java.util.Random;
import java.util.UUID;

public class ContaBancaria {
    private UUID idConta;
    private String instituicao;
    private double saldoConta;

    public ContaBancaria(String instituicao, double saldoConta){
        this.instituicao = instituicao;
        this.saldoConta = saldoConta;
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

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
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
