package br.com.cz.Controller;

import br.com.cz.Dao.RendaDAO;
import br.com.cz.Exception.IdNotFoundException;
import br.com.cz.Exception.RendaException;
import br.com.cz.Interface.IDao;
import br.com.cz.Interface.IRendaController;
import br.com.cz.Model.PackageTransacao.Renda;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RendaController implements IRendaController {
    private IDao<Renda> dao;

    public RendaController() {
        this.dao = new RendaDAO();
    }
    @Override
    public boolean adicionarRenda(Renda renda) {
        try {
            if (renda != null) {
                return this.dao.adicionar(renda);
            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editarRenda(String idDaTransacao, Renda rendaNova) {
        try {
            if (idDaTransacao != null) {
                return this.dao.atualizar(idDaTransacao, rendaNova);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerRenda(Renda renda) {
        try {
            if (renda != null) {
                return this.dao.remover(renda);
            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerRenda(String idDaTransacao) {
        try {
            if (idDaTransacao != null) {
                Renda renda = this.dao.buscar(idDaTransacao);
                return this.dao.remover(renda);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Renda buscarRenda(String idDaTransacao) {
        try {
            if (idDaTransacao != null) {
                return this.dao.buscar(idDaTransacao);

            } else {
                throw new RendaException();
            }
        } catch (RendaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Renda> buscarRenda(UUID idDaConta, UUID idUtilizador) {
        try {
            List<Renda> rendas = this.dao.listar();
            List<Renda> rendasUtlEsp = new ArrayList<>();

            if (idDaConta != null && idUtilizador != null) {
                for (Renda rnd : rendas) {
                    if (rnd.getIdConta().equals(idDaConta) && rnd.getIdUtilizador().equals(idUtilizador)) {
                        rendasUtlEsp.add(rnd);
                    }
                }
                return rendasUtlEsp;
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Renda> listarRendas(UUID idUtilizador) {
        try {
            List<Renda> rendas = this.dao.listar();
            List<Renda> rendasUtl = new ArrayList<>();

            if (rendas != null && idUtilizador != null) {
                for (Renda rnd : rendas) {
                    if (rnd.getIdUtilizador().equals(idUtilizador)) {
                        rendasUtl.add(rnd);
                    }
                }
                return  rendasUtl;
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
