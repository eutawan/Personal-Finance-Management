package br.com.cz.Controller;

import br.com.cz.Dao.DespesaDAO;
import br.com.cz.Exception.DespesaException;
import br.com.cz.Exception.IdNotFoundException;
import br.com.cz.Exception.IdadeInvalidaException;
import br.com.cz.Exception.NaoPagoException;
import br.com.cz.Interface.IDao;
import br.com.cz.Interface.IDespesaController;
import br.com.cz.Model.PackageTransacao.Despesa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DespesaController implements IDespesaController {

    private IDao<Despesa> dao;

    public DespesaController() {
        this.dao = new DespesaDAO();
    }
    @Override
    public boolean adicionarDespesa(Despesa despesa) {
        try{
            if (despesa != null && despesa.isFoiPago()) {
                if (despesa.isFoiPago()) {
                    return this.dao.adicionar(despesa);
                }
                throw new NaoPagoException();
            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Despesa> listarDespesa(UUID idUtilizador) {
        try {
            List<Despesa> despesas = this.dao.listar();
            List<Despesa> despesasUtl = new ArrayList<>();

            if (despesas != null && idUtilizador != null) {
                for (Despesa dsp : despesas) {
                    if (dsp.getIdUtilizador().equals(idUtilizador)) {
                        despesasUtl.add(dsp);
                    }
                }
                return despesasUtl;
            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Despesa buscarDespesa(String idDaTransacao) {
        try{
            if (idDaTransacao != null) {
                return this.dao.buscar(idDaTransacao);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Despesa> buscarDespesas(UUID idDaConta, UUID idUtilizador) {
        try{
            List<Despesa> despesas = this.dao.listar();
            List<Despesa> despesasUtlEsp = new ArrayList<>();

            if (idUtilizador != null && idDaConta != null) {
                for (Despesa dsp : despesas) {
                    if (dsp.getIdUtilizador().equals(idUtilizador) && dsp.getIdConta().equals(idDaConta)) {
                        despesasUtlEsp.add(dsp);
                    }
                }
                return despesasUtlEsp;
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean editarDespesa(String idDaTransacao, Despesa despesaNova) {
        try{
            if (idDaTransacao != null) {
                return this.dao.atualizar(idDaTransacao, despesaNova);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerDespesa(String idDaDaTransacao) {
        try{
            if (idDaDaTransacao != null) {
                Despesa despesa = this.dao.buscar(idDaDaTransacao);
                return this.dao.remover(despesa);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerDespesa(Despesa despesa) {
        try{
            if (despesa != null) {
                return this.dao.remover(despesa);
            } else {
                throw new DespesaException();
            }
        } catch (DespesaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
