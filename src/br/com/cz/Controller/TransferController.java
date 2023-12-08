package br.com.cz.Controller;

import br.com.cz.Dao.TransferDAO;
import br.com.cz.Exception.IdNotFoundException;
import br.com.cz.Exception.TransferException;
import br.com.cz.Interface.IDao;
import br.com.cz.Interface.ITransferController;
import br.com.cz.Model.PackageTransacao.Transferencia;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransferController implements ITransferController {
    private IDao<Transferencia> dao;

    public TransferController() {
        this.dao = new TransferDAO();
    }
    @Override
    public boolean adicionarTransfer(Transferencia transferencia) {
        try {
            if (transferencia != null) {
                return this.dao.adicionar(transferencia);
            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Transferencia> listarTransfers(UUID idUtilizador) {
        try {
            List<Transferencia> transfers = this.dao.listar();
            List<Transferencia> transfersUtl = new ArrayList<>();

            if (transfers != null && idUtilizador != null) {
                for (Transferencia trn : transfers) {
                    if (trn.getIdUtilizador().equals(idUtilizador)) {
                        transfersUtl.add(trn);
                    }
                }
                return transfersUtl;
            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Transferencia buscarTransfer(String idDaTransacao) {
        try {
            if (idDaTransacao != null) {
                return this.dao.buscar(idDaTransacao);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Transferencia> buscarTransfer(UUID idDaConta, UUID idUtilizador) {
        try {
            List<Transferencia> transfers = this.dao.listar();
            List<Transferencia> transfersUtlEsp = new ArrayList<>();

            if (idDaConta != null && idUtilizador != null) {
                for (Transferencia trn : transfers) {
                    if (trn.getIdUtilizador().equals(idUtilizador)) {
                        transfersUtlEsp.add(trn);
                    }
                }
                return transfersUtlEsp;

            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean editarTransfer(String idDaTransacao, Transferencia transferNova) {
        try {
            if (idDaTransacao != null) {
                return this.dao.atualizar(idDaTransacao, transferNova);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerTransfer(String idDaDaTransacao) {
        try {
            if (idDaDaTransacao != null) {
                Transferencia transfer = this.dao.buscar(idDaDaTransacao);
                return this.dao.remover(transfer);
            } else {
                throw new IdNotFoundException();
            }
        } catch (IdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerTransfer(Transferencia transferencia) {
        try {
            if (transferencia != null) {
                return this.dao.remover(transferencia);
            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
