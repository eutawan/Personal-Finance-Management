package br.com.cz.Model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class TipoTransacao {
    private UUID idTransacao;
    private String instituicao;
    private double valor;
    private LocalDate data;
    private String metodoDePagamento;

    public TipoTransacao(String instituicao, double valor, String metodoDePagamento){
        this.instituicao = instituicao;
        this.valor = valor;
        this.metodoDePagamento = metodoDePagamento;
        this.idTransacao = UUID.randomUUID();
        this.data = LocalDate.now();


    }
}
