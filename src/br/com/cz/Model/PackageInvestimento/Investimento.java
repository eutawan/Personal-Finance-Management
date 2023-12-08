package br.com.cz.Model.PackageInvestimento;

import java.util.UUID;

public class Investimento<T extends TipoInvestimento> {
     private String idInvestimento;
    private UUID idUtilizador;
    private UUID idConta;
    private T investimento;


    public Investimento(UUID idUtilizador, UUID idConta, T investimento){
        this.idInvestimento = UUID.randomUUID().toString();
        this.idUtilizador = idUtilizador;
        this.idConta = idConta;
        this.investimento = investimento;
    }

    public String getIdInvestimento() {
        return idInvestimento;
    }

    public UUID getIdUtilizador() {
        return idUtilizador;
    }

    public UUID getIdConta() {
        return idConta;
    }

    public T getInvestimento() {
        return investimento;
    }

    public void setInvestimento(T investimento) {
        this.investimento = investimento;
    }
}
