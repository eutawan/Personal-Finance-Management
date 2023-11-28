package br.com.cz.Main;
import br.com.cz.Controller.AutenticacaoController;
import br.com.cz.Exception.UtilizadorException;
import br.com.cz.Model.Pessoal;
import br.com.cz.Model.Profissional;
import br.com.cz.Util.SistemaAplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutenticacaoController autenticacaoController = new AutenticacaoController();
        SistemaAplicacao sistema = new SistemaAplicacao();

        while (true) {
            String op = sistema.menuInicial();

            if (op.equals("1")) {
                Scanner ler = new Scanner(System.in);

                System.out.println("""
                1 - Pessoal
                2 - Profissional""");

                System.out.print("Selecione uma opcao de Cadastro: ");
                int op2 = ler.nextInt();
                ler.nextLine();

                if (op2 == 1) {
                    System.out.print("Digite seu nome: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite sua idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();

                    Pessoal contaPessoal = new Pessoal(nome, idade);

                    System.out.print("Digite seu nome de usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = ler.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = ler.nextLine();

                    boolean cadastro = autenticacaoController.cadastro();

                    if (cadastro) {
                        System.out.println("=-=- CADASTRO REALIZADO COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- CADASTRO NÃO REALIZADO -=-=");
                    }

                } else if (op2 == 2) {
                    System.out.print("Digite seu nome: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite sua idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Digite sua Profissao: ");
                    String profissao = ler.nextLine();

                    Profissional contaProfissional = new Profissional(nome, idade, profissao);

                    System.out.print("Digite seu nome de usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = ler.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = ler.nextLine();


                   boolean cadastro = autenticacaoController.cadastro();

                    if (cadastro) {
                        System.out.println("=-=- CADASTRO REALIZADO COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- CADASTRO NÃO REALIZADO -=-=");
                    }
                }

            } else if (op.equals("2")) {
                while (true) {
                    Scanner ler = new Scanner(System.in);
                    System.out.print("Digite seu nome de Usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = ler.nextLine();

                    boolean login = autenticacaoController.login();

                    if (login) {
                        op = sistema.menuPrincipal();
                        if (op.equals("1")) {
                            while (true) {
                                op = sistema.menuConta();
                                if (op.equals("1")) {

                                } else if (op.equals("2")) {

                                } else if (op.equals("3")) {

                                } else if (op.equals("4")) {

                                } else if (op.equals("0")) {
                                    System.out.println("-=-= VOLTAR =-=-");
                                    break;
                                }

                            }
                        } else if (op.equals("2")) {
                            while (true) {
                                op = sistema.menuTransacao();
                                if (op.equals("1")) {

                                } else if (op.equals("2")) {

                                } else if (op.equals("3")) {

                                } else if (op.equals("0")) {
                                    System.out.println("-=-= VOLTAR =-=-");
                                    break;
                                }
                            }

                        } else if (op.equals("3")) {
                            while (true) {
                                op = sistema.menuInvestimento();
                                if (op.equals("1")) {

                                } else if (op.equals("2")) {

                                } else if (op.equals("3")) {

                                } else if (op.equals("0")) {
                                    System.out.println("-=-= VOLTAR =-=-");
                                    break;
                                }

                            }

                        } else if (op.equals("0")) {
                            System.out.println("-=-= VOLTAR =-=-");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (op.equals("3")) {
                Scanner ler = new Scanner(System.in);
                System.out.print("Digite seu nome de Usuario: ");
                String nomeUsuario = ler.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = ler.nextLine();

                boolean excluir = autenticacaoController.excluirConta();

                if (excluir) {
                    System.out.println("=-=- CONTA EXCLUIDA -=-=");
                } else {
                    System.out.println("=-=- FALHA NA EXCLUSAO -=-=");
                }
            } else if (op.equals("0")) {
                System.out.println("-=-= SAIR =-=-");
            }
        }
    }
}
