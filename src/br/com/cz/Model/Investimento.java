package br.com.cz.Model;
import java.util.UUID;

public class Investimento<T extends TipoInvestimento> {
     private UUID idInvestimento;
    private UUID idUtilizador;
    private UUID idConta;
    private T investimento;

    public Investimento(UUID idInvestimento, UUID idUtilizador, UUID idConta, T investimento){
        this.idInvestimento = idInvestimento;
        this.idUtilizador = idUtilizador;
        this.idConta = idConta;
        this.investimento = investimento;
    }

    public UUID getIdInvestimento() {
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
