package br.com.cz.Interface;

import br.com.cz.Model.Renda;

import java.util.List;
import java.util.UUID;

public interface IRendaController {
    boolean adicionarRenda(Renda renda);
    boolean editarRenda(String idDaTransacao, Renda rendaNova);
    boolean removerRenda(Renda renda);
    boolean removerRenda(String idDaTransacao);
    Renda buscarRenda(String idDaTransacao);
    List<Renda> buscarRenda(UUID idDaConta, UUID idUtilizador);
    List<Renda> listarRendas(UUID idUtilizador);
}
