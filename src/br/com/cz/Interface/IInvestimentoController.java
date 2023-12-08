package br.com.cz.Interface;
import br.com.cz.Model.PackageAutenticacao.Pessoa;
import br.com.cz.Model.PackageAutenticacao.Utilizador;

public interface IInvestimentoController {
    boolean adicionarInvestimento(Utilizador<? extends Pessoa> utl);
    boolean excluirInvestimento(Utilizador<? extends Pessoa> utl);
    boolean excluirInvestimento(String senha, String nomeUsuario);
    Utilizador<? extends Pessoa> buscarInvestimento(String nomeUsuario);
    boolean buscarInvestimento(String nomeUsuario, String senha);
    boolean atualizarInvestimento(String nomeUsuario, String senha, Utilizador<? extends Pessoa> utl);

}
