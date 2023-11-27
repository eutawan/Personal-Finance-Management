package br.com.cz.Controller;

import br.com.cz.Dao.UtilizadorDAO;
import br.com.cz.Exception.UtilizadorException;
import br.com.cz.Interface.IAutenticacaoController;
import br.com.cz.Interface.IDao;
import br.com.cz.Model.Pessoa;
import br.com.cz.Model.Pessoal;
import br.com.cz.Model.Profissional;
import br.com.cz.Model.Utilizador;

import java.util.Scanner;

public class AutenticacaoController implements IAutenticacaoController {
    private IDao<Utilizador<? extends Pessoa>> dao;

    public AutenticacaoController() {
        this.dao = new UtilizadorDAO();
    }

    @Override
    public boolean cadastro() {
        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("""
                1 - Pessoal
                2 - Profissional""");
            System.out.print("Selecione uma opcao de Cadastro: ");
            int op = ler.nextInt();
            ler.nextLine();

            if (op == 1) {
                System.out.print("Digite seu nome: ");
                String nome = ler.nextLine();
                System.out.print("Digite sua idade: ");
                int idade = ler.nextInt();
                ler.nextLine();
                if (idade < 16) {
                    throw new RuntimeException("Incapaz de criar conta para menores de 16 anos");
                }
                System.out.print("Digite seu nome de usuario: ");
                String nomeUsuario = ler.nextLine();
                System.out.print("Digite seu email: ");
                String email = ler.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = ler.nextLine();

                Pessoal contaPessoal = new Pessoal(nome, idade);

                dao.adicionar(new Utilizador<Pessoal>(nomeUsuario, email, senha, contaPessoal));
                return true;

            } else if (op == 2) {
                System.out.print("Digite seu nome: ");
                String nome = ler.nextLine();
                System.out.print("Digite sua idade: ");
                int idade = ler.nextInt();
                ler.nextLine();
                if (idade < 16) {
                    throw new RuntimeException("Incapaz de criar conta para menores de 16 anos");
                }
                System.out.print("Digite sua Profissao: ");
                String profissao = ler.nextLine();

                Profissional contaProfissional = new Profissional(nome, idade, profissao);

                System.out.print("Digite seu nome de usuario: ");
                String nomeUsuario = ler.nextLine();
                System.out.print("Digite seu email: ");
                String email = ler.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = ler.nextLine();

                dao.adicionar(new Utilizador<Profissional>(nomeUsuario, email, senha, contaProfissional));
                return true;
            }
        } catch (UtilizadorException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void login() {

    }

    @Override
    public void excluirConta() {

    }
}
