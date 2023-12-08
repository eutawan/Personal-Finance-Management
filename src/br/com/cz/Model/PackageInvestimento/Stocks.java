package br.com.cz.Model.PackageInvestimento;
import br.com.cz.Model.PackageInvestimento.TipoInvestimento;

import java.time.LocalDate;

public class Stocks extends TipoInvestimento {
    public Stocks(LocalDate dataDeCompra, int qntInvestida, double cotacao, String ativo,
                  String instituicaoFinanceira){
        super(dataDeCompra, qntInvestida, cotacao, ativo, instituicaoFinanceira);

    }
}
