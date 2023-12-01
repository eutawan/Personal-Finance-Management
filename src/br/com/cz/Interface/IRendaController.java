package br.com.cz.Interface;

import br.com.cz.Model.Renda;

import java.util.List;
import java.util.UUID;

public interface IRendaController {
    boolean adicionarRenda(Renda renda);
    boolean atualizarRenda(String idDaTransacao, Renda renda);
    boolean removerRenda(Renda renda);
    boolean removerRenda(String idDaTransacao);
    Renda buscarRenda(String idDaTransacao);
    Renda buscarRenda(UUID idDaConta, String idDaTransacao);
    List<Renda> listarRendas();
}
