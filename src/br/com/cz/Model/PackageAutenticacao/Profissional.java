package br.com.cz.Model.PackageAutenticacao;

import br.com.cz.Model.PackageAutenticacao.Pessoa;

public class Profissional extends Pessoa {
    private String profissao;
    public Profissional(String nome, int idade, String profissao) {
        super(nome, idade);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Profissional{" +
                "profissao='" + profissao + '\'' +
                '}';
    }
}
