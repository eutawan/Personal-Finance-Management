package br.com.cz.Controller;

import br.com.cz.Dao.UtilizadorDAO;
import br.com.cz.Exception.IdadeInvalidaException;
import br.com.cz.Exception.SenhaIncorretaException;
import br.com.cz.Exception.UtilizadorException;
import br.com.cz.Interface.IAutenticacaoController;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.PackageAutenticacao.Pessoa;
import br.com.cz.Model.PackageAutenticacao.Utilizador;

public class AutenticacaoController implements IAutenticacaoController {
    private IDao<Utilizador<? extends Pessoa>> dao;

    public AutenticacaoController() {
        this.dao = new UtilizadorDAO();
    }

    @Override
    public boolean adicionarUtilizador(Utilizador<? extends Pessoa> utl) {
        try {
            if (utl != null) {
                if (utl.getPessoa().getIdade() < 16) {
                    throw new IdadeInvalidaException();
                } else {
                    return this.dao.adicionar(utl);
                }
            } else {
                throw new UtilizadorException();
            }
        } catch (IdadeInvalidaException | UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirUtilizador(Utilizador<? extends Pessoa> utl) {
        try {
            if (utl != null) {
                return this.dao.remover(utl);
            } else {
                throw new UtilizadorException();
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluirUtilizador(String nomeDeUsuario, String senha) {
        try {
            Utilizador<? extends Pessoa> utlBuscado = this.dao.buscar(nomeDeUsuario);

            if (utlBuscado != null) {
                boolean senhaCorreta = utlBuscado.getSenha().equals(senha);
                if (senhaCorreta) {
                    return this.dao.remover(utlBuscado);
                } else {
                    throw new SenhaIncorretaException();
                }
            } else {
                throw new UtilizadorException();
            }
        } catch (UtilizadorException | SenhaIncorretaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Utilizador<? extends Pessoa> buscarUtilizador(String nomeDeUsuario) {
        try {
            Utilizador<? extends Pessoa> utlBuscado = this.dao.buscar(nomeDeUsuario);

            if (utlBuscado != null) {
                return utlBuscado;
            } else {
                throw new UtilizadorException();
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean buscarUtilizador(String nomeDeUsuario, String senha) {
        try {
            Utilizador<? extends Pessoa> utlBuscado = this.dao.buscar(nomeDeUsuario);

            if (utlBuscado != null) {
                boolean senhaCorreta = utlBuscado.getSenha().equals(senha);
                if (senhaCorreta) {
                    return true;
                } else {
                    throw new SenhaIncorretaException();
                }
            } else {
                throw new UtilizadorException();
            }
        } catch (UtilizadorException | SenhaIncorretaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizarUtilizador(String nomeDeUsuario, String senha, Utilizador<? extends Pessoa> utl) {
        try {
            Utilizador<? extends Pessoa> utlBuscado = this.dao.buscar(nomeDeUsuario);

            if (utlBuscado != null && utl != null) {
                boolean senhaCorreta = utlBuscado.getSenha().equals(senha);
                if (senhaCorreta) {
                    return this.dao.atualizar(nomeDeUsuario, utl);
                } else {
                    throw new SenhaIncorretaException();
                }
            } else {
                throw new UtilizadorException();
            }
        } catch (UtilizadorException | SenhaIncorretaException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
