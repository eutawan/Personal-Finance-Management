package br.com.cz.Controller;

import br.com.cz.Exception.TransferException;
import br.com.cz.Interface.ITransferController;
import br.com.cz.Model.Transferencia;

import javax.imageio.ImageTranscoder;
import java.util.List;
import java.util.UUID;

public class TransferController implements ITransferController {
    @Override
    public boolean adicionarTransfer(Transferencia transferencia) {
        try {
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Transferencia> listarTransfers() {
        try {
            if () {

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
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Transferencia buscarTransfer(UUID idDaConta, String idDaTransacao) {
        try {
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean editarTransfer(String idDaTransacao, Transferencia transferNova) {
        try {
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerTransfer(String idDaDaTransacao) {
        try {
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removerTransfer(Transferencia transferencia) {
        try {
            if () {

            } else {
                throw new TransferException();
            }
        } catch (TransferException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
