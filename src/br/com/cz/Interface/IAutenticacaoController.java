package br.com.cz.Interface;


import br.com.cz.Model.Pessoa;
import br.com.cz.Model.Utilizador;

import java.util.ArrayList;
import java.util.UUID;

public interface IAutenticacaoController {

    boolean adicionarUtilizador(Utilizador<? extends Pessoa> utl);
    boolean excluirUtilizador(Utilizador<? extends Pessoa> utl);
    boolean excluirUtilizador(String nomeDeUsuario, String senha);
    boolean buscarUtilizador(Utilizador<? extends Pessoa> utl);
    boolean buscarUtilizador(String nomeDeUsuario);
    boolean atualizarUtilizador(String nomeDeUsuario, String senha, Utilizador<? extends Pessoa> utl);
}
