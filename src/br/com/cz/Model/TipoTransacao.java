package br.com.cz.Model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class TipoTransacao {
    private String idTransacao;
    private UUID idConta;
    private String instituicao;
    private double valor;
    private LocalDate data;
    private String metodoDePagamento;

    public TipoTransacao(String instituicao, double valor, String metodoDePagamento, UUID idConta){
        this.instituicao = instituicao;
        this.valor = valor;
        this.metodoDePagamento = metodoDePagamento;
        this.idTransacao = UUID.randomUUID().toString();
        this.data = LocalDate.now();
        this.idConta = idConta;
    }

    public String getIdTransacao() {
        return idTransacao;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(String metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    @Override
    public String toString() {
        return "TipoTransacao{" +
                "idTransacao=" + idTransacao +
                ", instituicao='" + instituicao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", metodoDePagamento='" + metodoDePagamento + '\'' +
                '}';
    }
}
