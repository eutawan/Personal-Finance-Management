package br.com.cz.Model;
import java.time.LocalDate;

public class Criptomoeda extends TipoInvestimento {
    public Criptomoeda(LocalDate dataDeCompra, int qntInvestida, double cotacao, String ativo,
                       String instituicaoFinanceira) {
        super(dataDeCompra, qntInvestida, cotacao, ativo, instituicaoFinanceira);
    }
}
