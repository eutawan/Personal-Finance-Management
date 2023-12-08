package br.com.cz.Interface;


import br.com.cz.Model.PackageAutenticacao.Pessoa;
import br.com.cz.Model.PackageAutenticacao.Utilizador;

public interface IAutenticacaoController {

    boolean adicionarUtilizador(Utilizador<? extends Pessoa> utl);
    boolean excluirUtilizador(Utilizador<? extends Pessoa> utl);
    boolean excluirUtilizador(String nomeDeUsuario, String senha);
    Utilizador<? extends Pessoa> buscarUtilizador(String nomeDeUsuario);
    boolean buscarUtilizador(String nomeDeUsuario, String senha);
    boolean atualizarUtilizador(String nomeDeUsuario, String senha, Utilizador<? extends Pessoa> utl);
}
