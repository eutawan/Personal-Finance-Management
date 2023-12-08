package br.com.cz.Controller;

import br.com.cz.Dao.InvestimentoDAO;
import br.com.cz.Exception.IdNotFoundException;
import br.com.cz.Exception.InvestimentoException;
import br.com.cz.Exception.RendaException;
import br.com.cz.Interface.IDao;
import br.com.cz.Interface.IInvestimentoController;
import br.com.cz.Model.PackageAutenticacao.Pessoa;
import br.com.cz.Model.PackageAutenticacao.Utilizador;
import br.com.cz.Model.PackageInvestimento.Investimento;
import br.com.cz.Model.PackageInvestimento.TipoInvestimento;

import java.util.ArrayList;
import java.util.List;

public class InvestimentoController implements IInvestimentoController {
    private IDao<Investimento<? extends TipoInvestimento>> dao;

    public InvestimentoController() {
        this.dao = new InvestimentoDAO();
    }

    @Override
    public boolean adicionarInvestimento(Investimento<? extends TipoInvestimento> invest) {
        try {
            if (invest != null) {
                return this.dao.adicionar(invest);
            } else {
                throw new InvestimentoException();
            }
        } catch (InvestimentoException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirInvestimento(Investimento<? extends TipoInvestimento> invest) {
        try {
            if (invest != null) {
                return this.dao.remover(invest);
            } else {
                throw new InvestimentoException();
            }
        } catch (InvestimentoException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirInvestimento(String idInvest) {
        try {
            if (idInvest != null) {
                Investimento<? extends TipoInvestimento> investBuscado = dao.buscar(idInvest);

                if (investBuscado != null) {
                   return this.dao.remover(investBuscado);
                } else {
                    throw new InvestimentoException();
                }
            } else {
                throw new IdNotFoundException();
            }
        } catch (InvestimentoException | IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Investimento<? extends TipoInvestimento> buscarInvestimento(String idInvest) {
        try {
            if (idInvest != null) {
                Investimento<? extends TipoInvestimento> investBuscado = dao.buscar(idInvest);

                if (investBuscado != null) {
                    return investBuscado;
                } else {
                    throw new InvestimentoException();
                }
            } else {
                throw new IdNotFoundException();
            }
        } catch (InvestimentoException | IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    @Override
    public boolean atualizarInvestimento(String idInvest, Investimento<? extends TipoInvestimento> investNew) {
        try {
            if (idInvest != null) {
                if (investNew != null) {
                    return this.dao.atualizar(idInvest, investNew);
                } else {
                    throw new InvestimentoException();
                }
            } else {
                throw new IdNotFoundException();
            }
        } catch (InvestimentoException | IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Investimento<? extends TipoInvestimento>> listarInvestimentos(String idUtilizador) {
        try {
            if (idUtilizador != null) {
                List<Investimento<? extends TipoInvestimento>> listInvest = this.dao.listar();
                List<Investimento<? extends TipoInvestimento>> listInvestUtl = new ArrayList<>();

                if (listInvest != null) {
                    for (Investimento<? extends TipoInvestimento> invest : listInvest) {
                        if (invest.getIdUtilizador().equals(idUtilizador)) {
                            listInvestUtl.add(invest);
                        }
                    }
                    return listInvestUtl;
                } else {
                    throw new InvestimentoException();
                }
            } else {
                throw new IdNotFoundException();
            }
        } catch (InvestimentoException | IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
