package br.com.cz.Main;
import br.com.cz.Controller.*;
import br.com.cz.Exception.LimiteDespesaException;
import br.com.cz.Exception.NaoPagoException;
import br.com.cz.Exception.OptionException;
import br.com.cz.Model.*;
import br.com.cz.Util.SistemaAplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AutenticacaoController autenticacaoController = new AutenticacaoController();
        ContaBancariaController contaBancariaController = new ContaBancariaController();
        DespesaController despesaController = new DespesaController();
        RendaController rendaController = new RendaController();
        TransferController transferController = new TransferController();

        SistemaAplicacao sistema = new SistemaAplicacao();

        while (true) {
            String op = sistema.menuInicial();

            if (op.equals("1")) {
                Scanner ler = new Scanner(System.in);

                System.out.print("\n1 - Pessoal\n" +
                        "2 - Profissional\n");

                System.out.print("Selecione uma opcao de Cadastro: ");
                int op2 = ler.nextInt();
                ler.nextLine();

                if (op2 == 1) {
                    System.out.print("\nDigite seu nome: ");
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

                    Utilizador<Pessoal> utilizador = new Utilizador<>(nomeUsuario, email, senha, contaPessoal);

                    boolean cadastro = autenticacaoController.adicionarUtilizador(utilizador);

                    if (cadastro) {
                        System.out.println("=-=- CADASTRO REALIZADO COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- CADASTRO NÃO REALIZADO -=-=");
                    }

                } else if (op2 == 2) {
                    System.out.print("\nDigite seu nome: ");
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

                    Utilizador<Profissional> utilizador = new Utilizador<>(nomeUsuario, email, senha, contaProfissional);


                    boolean cadastro = autenticacaoController.adicionarUtilizador(utilizador);

                    if (cadastro) {
                        System.out.println("=-=- CADASTRO REALIZADO COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- CADASTRO NÃO REALIZADO -=-=");
                    }
                } else {
                    throw new OptionException();
                }

            }
            else if (op.equals("2")) {
                while (true) {
                    Scanner ler = new Scanner(System.in);
                    System.out.print("\nDigite seu nome de Usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = ler.nextLine();

                    boolean login = autenticacaoController.buscarUtilizador(nomeUsuario, senha);

                    if (login) {
                        op = sistema.menuPrincipal();
                        if (op.equals("1")) {
                            while (true) {
                                op = sistema.menuConta();
                                if (op.equals("1")) {
                                    System.out.println("-=-= CADASTRANDO CONTA BANCÁRIA =-=-");
                                    System.out.print("\nDigite o nome da instituição: ");
                                    String instituicao = ler.nextLine();
                                    System.out.print("Digite o saldo da conta: ");
                                    double saldoConta = ler.nextDouble();
                                    ler.nextLine();
                                    ContaBancaria contaBancaria = new ContaBancaria(instituicao, saldoConta, autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador());
                                    boolean cadastroConta = contaBancariaController.adicionarConta(contaBancaria);

                                    if (cadastroConta) {
                                        System.out.println("=-=- CONTA CADASTRADA COM SUCESSO -=-=");
                                    } else {
                                        System.out.println("=-=- NÃO FOI POSSÍVEL REALIZAR O CADASTRO -=-=");
                                    }
                                } else if (op.equals("2")) {
                                    System.out.println("=-=- CONTAS DO UTILIZADOR -=-=");
                                    ArrayList<ContaBancaria> contasBancarias = contaBancariaController.listarContas(autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador());

                                    for (ContaBancaria contasBancaria : contasBancarias) {
                                        System.out.println("\nInstituição: " + contasBancaria.getInstituicao());
                                        System.out.printf("Saldo da Conta: %.2f", contasBancaria.getSaldoConta());
                                    }

                                } else if (op.equals("3")) {
                                    System.out.println("=-=- REMOVER CONTA -=-=");
                                    System.out.print("\nDigite o nome da Instituíção que deseja remover: ");
                                    String instuicao = ler.nextLine();

                                    boolean removerConta = contaBancariaController.removerConta(instuicao);

                                    if (removerConta) {
                                        System.out.println("=-=- CONTA REMOVIDA COM SUCESSO -=-=");
                                    } else {
                                        System.out.println("=-=- NÃO FOI POSSÍVEL REMOVER A CONTA -=-=");
                                    }
                                } else if (op.equals("4")) {
                                    System.out.println("=-=- ATUALIZAR CONTA -=-=");
                                    System.out.println("\nDigite o nome da Insittuição que deseja atualizar: ");
                                    String instituicaoAtual = ler.nextLine();

                                    System.out.print("Deseja atualizar apenas o saldo? (Y/N): ");
                                    String resp = ler.next();

                                    switch (resp) {
                                        case "Y":
                                            System.out.println("Digite o novo Saldo: ");
                                            double saldoNovo = ler.nextDouble();
                                            ContaBancaria contaBancariaAtualizar = new ContaBancaria(instituicaoAtual, saldoNovo, autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador());
                                            contaBancariaController.atualizarConta(instituicaoAtual, contaBancariaAtualizar);
                                            break;
                                        case "N":
                                            System.out.print("Digite o novo nome da Instituição: ");
                                            String instituicaoNovo = ler.nextLine();
                                            System.out.print("Digite o novo Saldo: ");
                                            saldoNovo = ler.nextDouble();
                                            contaBancariaAtualizar = new ContaBancaria(instituicaoNovo, saldoNovo, autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador());
                                            contaBancariaController.atualizarConta(instituicaoAtual, contaBancariaAtualizar);
                                            break;
                                        default:
                                            System.out.println("Opção Inválida");
                                    }

                                } else if (op.equals("0")) {
                                    System.out.println("-=-= VOLTAR =-=-");
                                    break;
                                } else {
                                    throw new OptionException();
                                }
                            }
                        }
                        else if (op.equals("2")) {
                            while (true) {
                                op = sistema.menuTransacao();
                                if (op.equals("1")) {
                                    while (true) {
                                        op = sistema.menuDespesa();
                                        if (op.equals("1")) {
                                            System.out.print("\nDigite o valor da Despesa: ");
                                            double valor = ler.nextDouble();
                                            ler.nextLine();
                                            System.out.print("Digite o nome da instituição: ");
                                            String nomeInstituicao = ler.nextLine();
                                            System.out.print("Digite o método de pagamento: ");
                                            String metodoPagamento = ler.nextLine();
                                            System.out.print("Foi pago? (y/n): ");
                                            String isFoiPago = ler.next();
                                            boolean foiPago;
                                            if (isFoiPago.toLowerCase().equals("y")) {
                                                foiPago = true;
                                            } else {
                                                foiPago = false;
                                            }
                                            ContaBancaria contaBancaria = contaBancariaController.buscarConta(nomeInstituicao);
                                            UUID idContaBancaria = contaBancaria.getIdUtilizador();
                                            UUID idUtilizador = autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador();
                                            Despesa despesa = new Despesa(nomeInstituicao, valor, metodoPagamento,  idContaBancaria, idUtilizador, foiPago);

                                            try {
                                                if (foiPago) {
                                                    despesaController.adicionarDespesa(despesa);
                                                    double saldoAtual = contaBancaria.getSaldoConta();

                                                    if (saldoAtual < valor) {
                                                        throw new LimiteDespesaException();
                                                    }

                                                    contaBancaria.setSaldoConta(saldoAtual - valor);
                                                    System.out.println("=-=- DESPESA CRIADA COM SUCESSO");
                                                } else {
                                                    throw new NaoPagoException();
                                                }
                                            } catch (NaoPagoException | LimiteDespesaException e) {
                                                System.err.println(e.getMessage());
                                            }

                                        }
                                        else if (op.equals("2")) {
                                            System.out.print("\ndigite o id da transação que deseja alterar: ");
                                            String idTransacao = ler.nextLine();

                                            String resposta;
                                            double valor;
                                            double diferencaValor = 0;
                                            String nomeInstituicao;
                                            String metodoPagamento;
                                            boolean foiPago;
                                            UUID idConta;

                                            System.out.print("Deseja mudar o valor? (y/n): ");
                                            resposta = ler.nextLine();
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("Digite o novo valor: ");
                                                valor = ler.nextDouble();
                                                diferencaValor = valor - despesaController.buscarDespesa(idTransacao).getValor();
                                            } else {
                                                valor = despesaController.buscarDespesa(idTransacao).getValor();
                                            }
                                            System.out.print("Deseja mudar o nome da instituição? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("Digite o novo nome da instituição: ");
                                                nomeInstituicao = ler.nextLine();
                                                idConta = contaBancariaController.buscarConta(nomeInstituicao).getIdConta();
                                            } else {
                                                nomeInstituicao = despesaController.buscarDespesa(idTransacao).getInstituicao();
                                                idConta = despesaController.buscarDespesa(idTransacao).getIdConta();
                                            }
                                            System.out.print("Deseja mudar o metodoDePagamento? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("metodo de pagamento novo: ");
                                                metodoPagamento = ler.nextLine();
                                            } else {
                                                metodoPagamento = despesaController.buscarDespesa(idTransacao).getMetodoDePagamento();
                                            }
                                            System.out.print("Deseja mudar se a conta foi paga ou não? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                if (despesaController.buscarDespesa(idTransacao).isFoiPago()) {
                                                    foiPago = false;
                                                } else {
                                                    foiPago = true;
                                                }
                                            } else {
                                                foiPago = despesaController.buscarDespesa(idTransacao).isFoiPago();
                                            }

                                            Despesa newDespesa = new Despesa(nomeInstituicao, valor, metodoPagamento, idConta, autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador(), foiPago);
                                            despesaController.editarDespesa(idTransacao, newDespesa);
                                            contaBancariaController.buscarConta(nomeInstituicao).setSaldoConta(diferencaValor + contaBancariaController.buscarConta(nomeInstituicao).getSaldoConta());
                                        }
                                        else if (op.equals("3")) {
                                            System.out.print("\nDigite o id da transação que deseja remover: ");
                                            String idTransacao = ler.nextLine();

                                            Despesa despesaParaRemover = despesaController.buscarDespesa(idTransacao);
                                            boolean rmvDespesa = despesaController.removerDespesa(despesaParaRemover);

                                            if (rmvDespesa) {
                                                System.out.println("=-=- DESPESA REMOVIDA -=-=");
                                                ContaBancaria cnt = contaBancariaController.buscarConta(despesaParaRemover.getInstituicao());
                                                double saldoAtual = cnt.getSaldoConta();
                                                cnt.setSaldoConta(saldoAtual + despesaParaRemover.getValor());
                                            } else {
                                                System.out.println("=-=- NÃO FOI POSSÍVEL REMOVER A DESPESA -=-=");
                                            }


                                        }
                                        else if (op.equals("4")) {
                                            System.out.print("\nDeseja especificar de qual conta bancária verá as despesas? (y/n): ");
                                            String resposta = ler.nextLine();
                                            Utilizador<? extends Pessoa> utlDespesa = autenticacaoController.buscarUtilizador(nomeUsuario);

                                            if (!resposta.toLowerCase().equals("y")) {
                                                List<Despesa> listDespesas = despesaController.listarDespesa(utlDespesa.getIdUtilizador());

                                                for (Despesa dsp : listDespesas) {
                                                    if (dsp.getIdUtilizador().equals(utlDespesa.getIdUtilizador())) {
                                                        System.out.println("\nDESPESA " + dsp.getIdTransacao() + "\n" +
                                                                "Instituição: " + dsp.getInstituicao() + "\n" +
                                                                "Valor" + dsp.getValor() + "\n" +
                                                                "Método de Pagamento" + "\n" +
                                                                "Foi pago? " + dsp.isFoiPago() + "\n"
                                                                );
                                                    }
                                                }
                                            } else {
                                                System.out.print("Digite o nome da insituição: ");
                                                String nomeInstituicao = ler.nextLine();
                                                List<Despesa> listDespesas = despesaController.buscarDespesas(contaBancariaController.buscarConta(nomeInstituicao).getIdConta(), utlDespesa.getIdUtilizador());

                                                for (Despesa dsp : listDespesas) {
                                                    if (dsp.getIdUtilizador().equals(utlDespesa.getIdUtilizador())) {
                                                        System.out.println("\nDESPESA CONTA: " + dsp.getIdConta() +
                                                                "Id da Transação: "+ dsp.getIdTransacao() + "\n" +
                                                                "Instituição: " + dsp.getInstituicao() + "\n" +
                                                                "Valor" + dsp.getValor() + "\n" +
                                                                "Método de Pagamento" + "\n" +
                                                                "Foi pago? " + dsp.isFoiPago() + "\n"
                                                        );
                                                    }
                                                }
                                            }
                                        } else if (op.equals("0")) {
                                            System.out.println("=-=- SAINDO MENU DESPESA");
                                            break;

                                        } else {
                                            throw new OptionException();
                                        }
                                    }
                                } else if (op.equals("2")) {
                                    while (true) {
                                        op = sistema.menuRenda();
                                        if (op.equals("1")) {
                                            System.out.print("\nDigite o valor da Renda: ");
                                            double valor = ler.nextDouble();
                                            ler.nextLine();
                                            System.out.print("Digite o nome da instituição: ");
                                            String nomeInstituicao = ler.nextLine();
                                            System.out.print("Digite o método de pagamento: ");
                                            String metodoPagamento = ler.nextLine();
                                            System.out.print("Foi recebido? (y/n): ");
                                            String isFoiRecebido = ler.next();
                                            boolean foiRecebido;
                                            if (isFoiRecebido.toLowerCase().equals("y")) {
                                                foiRecebido = true;
                                            } else {
                                                foiRecebido = false;
                                            }
                                            ContaBancaria contaBancaria = contaBancariaController.buscarConta(nomeInstituicao);
                                            UUID idContaBancaria = contaBancaria.getIdUtilizador();
                                            UUID idUtilizador = autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador();
                                            Renda renda = new Renda(nomeInstituicao, valor, metodoPagamento,  idContaBancaria, idUtilizador, foiRecebido);

                                            try {
                                                if (foiRecebido) {
                                                    rendaController.adicionarRenda(renda);
                                                    double saldoAtual = contaBancaria.getSaldoConta();

                                                    contaBancaria.setSaldoConta(saldoAtual + valor);
                                                    System.out.println("=-=- RENDA CRIADA COM SUCESSO");
                                                } else {
                                                    throw new NaoPagoException();
                                                }
                                            } catch (NaoPagoException e) {
                                                System.err.println(e.getMessage());
                                            }

                                        }
                                        else if (op.equals("2")) {
                                            System.out.print("\ndigite o id da transação que deseja alterar: ");
                                            String idTransacao = ler.nextLine();

                                            String resposta;
                                            double valor;
                                            double diferencaValor = 0;
                                            String nomeInstituicao;
                                            String metodoPagamento;
                                            boolean foiRecebido;
                                            UUID idConta;

                                            System.out.print("Deseja mudar o valor? (y/n): ");
                                            resposta = ler.nextLine();
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("Digite o novo valor: ");
                                                valor = ler.nextDouble();
                                                diferencaValor = valor - rendaController.buscarRenda(idTransacao).getValor();
                                            } else {
                                                valor = rendaController.buscarRenda(idTransacao).getValor();
                                            }
                                            System.out.print("Deseja mudar o nome da instituição? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("Digite o novo nome da instituição: ");
                                                nomeInstituicao = ler.nextLine();
                                                idConta = contaBancariaController.buscarConta(nomeInstituicao).getIdConta();
                                            } else {
                                                nomeInstituicao = rendaController.buscarRenda(idTransacao).getInstituicao();
                                                idConta = rendaController.buscarRenda(idTransacao).getIdConta();
                                            }
                                            System.out.print("Deseja mudar o metodoDePagamento? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                System.out.print("metodo de pagamento novo: ");
                                                metodoPagamento = ler.nextLine();
                                            } else {
                                                metodoPagamento = rendaController.buscarRenda(idTransacao).getMetodoDePagamento();
                                            }
                                            System.out.print("Deseja mudar se a renda foi recebida ou não? (y/n): ");
                                            if (resposta.toLowerCase().equals("y")) {
                                                if (rendaController.buscarRenda(idTransacao).isFoiRecebido()) {
                                                    foiRecebido = false;
                                                } else {
                                                    foiRecebido = true;
                                                }
                                            } else {
                                                foiRecebido = rendaController.buscarRenda(idTransacao).isFoiRecebido();
                                            }

                                            Renda newRenda = new Renda(nomeInstituicao, valor, metodoPagamento, idConta, autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador(), foiRecebido);
                                            rendaController.editarRenda(idTransacao, newRenda);
                                            contaBancariaController.buscarConta(nomeInstituicao).setSaldoConta(diferencaValor + contaBancariaController.buscarConta(nomeInstituicao).getSaldoConta());
                                        }
                                        else if (op.equals("3")) {
                                            System.out.print("\nDigite o id da transação que deseja remover: ");
                                            String idTransacao = ler.nextLine();

                                            Renda rendaParaRemover = rendaController.buscarRenda(idTransacao);
                                            boolean rmvRenda = rendaController.removerRenda(rendaParaRemover);

                                            if (rmvRenda) {
                                                System.out.println("=-=- RENDA REMOVIDA -=-=");
                                                ContaBancaria cnt = contaBancariaController.buscarConta(rendaParaRemover.getInstituicao());
                                                double saldoAtual = cnt.getSaldoConta();
                                                cnt.setSaldoConta(saldoAtual - rendaParaRemover.getValor());
                                            } else {
                                                System.out.println("=-=- NÃO FOI POSSÍVEL REMOVER A RENDA -=-=");
                                            }

                                        }
                                        else if (op.equals("4")) {
                                            System.out.print("\nDeseja especificar de qual conta bancária verá as rendas? (y/n): ");
                                            String resposta = ler.nextLine();
                                            Utilizador<? extends Pessoa> utlRenda = autenticacaoController.buscarUtilizador(nomeUsuario);

                                            if (!resposta.toLowerCase().equals("y")) {
                                                List<Renda> listRendas = rendaController.listarRendas(utlRenda.getIdUtilizador());

                                                for (Renda rnd : listRendas) {
                                                    if (rnd.getIdUtilizador().equals(utlRenda.getIdUtilizador())) {
                                                        System.out.println("\nDESPESA " + rnd.getIdTransacao() + "\n" +
                                                                "Instituição: " + rnd.getInstituicao() + "\n" +
                                                                "Valor" + rnd.getValor() + "\n" +
                                                                "Método de Pagamento" + "\n" +
                                                                "Foi pago? " + rnd.isFoiRecebido() + "\n"
                                                        );
                                                    }
                                                }
                                            } else {
                                                System.out.print("Digite o nome da insituição: ");
                                                String nomeInstituicao = ler.nextLine();
                                                List<Renda> listRendas = rendaController.buscarRenda(contaBancariaController.buscarConta(nomeInstituicao).getIdConta(), utlRenda.getIdUtilizador());

                                                for (Renda rnd : listRendas) {
                                                    if (rnd.getIdUtilizador().equals(utlRenda.getIdUtilizador())) {
                                                        System.out.println("\nDESPESA CONTA: " + rnd.getIdConta() +
                                                                "Id da Transação: "+ rnd.getIdTransacao() + "\n" +
                                                                "Instituição: " + rnd.getInstituicao() + "\n" +
                                                                "Valor" + rnd.getValor() + "\n" +
                                                                "Método de Pagamento" + "\n" +
                                                                "Foi pago? " + rnd.isFoiRecebido() + "\n"
                                                        );
                                                    }
                                                }
                                            }
                                        }
                                        else if (op.equals("0")) {
                                            System.out.println("=-=- SAINDO MENU RENDA");
                                            break;

                                        } else {
                                            throw new OptionException();
                                        }
                                    }
                                } else if (op.equals("3")) {
                                    while (true) {
                                        op = sistema.menuTransfer();
                                        if (op.equals("1")) {
                                            System.out.println("Digite o valor da transferência: ");
                                            double valor = ler.nextDouble();
                                            ler.nextLine();
                                            System.out.println("Digite o nome da instituição: ");
                                            String nomeInstituicao = ler.nextLine();
                                            System.out.println("Digite o método de pagamento: ");
                                            String metodoPagamento = ler.nextLine();

                                            Transferencia transferencia = transferController.buscarTransfer(nomeInstituicao);
                                            UUID idContaBancaria = transferencia.getIdConta();
                                            UUID idUtilizador = autenticacaoController.buscarUtilizador(nomeUsuario).getIdUtilizador();



                                        } else if (op.equals("2")) {

                                        } else if (op.equals("3")) {

                                        } else if (op.equals("4")) {

                                        } else if (op.equals("0")) {
                                            System.out.println("=-=- SAINDO MENU TRANSFERENCIA -=-=");
                                            break;

                                        } else {
                                            throw new OptionException();
                                        }
                                    }
                                } else if (op.equals("0")) {
                                    System.out.println("-=-= VOLTAR =-=-");
                                    break;
                                } else {
                                    throw new OptionException();
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
                        } else {
                            throw new OptionException();
                        }
                    } else {
                        throw new OptionException();
                    }
                }
            }
            else if (op.equals("3")) {
                Scanner ler = new Scanner(System.in);
                System.out.print("Digite seu nome de Usuario: ");
                String nomeUsuario = ler.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = ler.nextLine();

                boolean excluir = autenticacaoController.excluirUtilizador(nomeUsuario, senha);

                if (excluir) {
                    System.out.println("=-=- CONTA EXCLUIDA -=-=");
                } else {
                    System.out.println("=-=- FALHA NA EXCLUSAO -=-=");
                }

            }
            else if (op.equals("4")) {
                Scanner ler = new Scanner(System.in);

                System.out.print("Digite seu nome de Usuario atual: ");
                String nomeUsuarioAtual = ler.nextLine();
                System.out.print("Digite sua senha atual: ");
                String senhaAtual = ler.nextLine();

                System.out.println("""
                        1 - Pessoal
                        2 - Profissional""");

                System.out.print("Selecione uma opcao de Cadastro: ");
                int op2 = ler.nextInt();
                ler.nextLine();

                if (op2 == 1) {
                    System.out.print("Digite seu novo nome: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite sua nova idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();

                    Pessoal contaPessoal = new Pessoal(nome, idade);

                    System.out.print("Digite seu novo nome de usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite seu novo email: ");
                    String email = ler.nextLine();
                    System.out.print("Digite sua nova senha: ");
                    String senha = ler.nextLine();

                    Utilizador<Pessoal> utilizadorNovo = new Utilizador<>(nomeUsuario, email, senha, contaPessoal);

                    boolean atualizacao = autenticacaoController.atualizarUtilizador(nomeUsuarioAtual, senhaAtual, utilizadorNovo);

                    if (atualizacao) {
                        System.out.println("=-=- ATUALIZACAO REALIZADA COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- ATUALIZACAO NÃO REALIZADA -=-=");
                        ;
                    }

                } else if (op2 == 2) {
                    System.out.print("Digite seu novo nome: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite sua nova idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Digite sua nova Profissao: ");
                    String profissao = ler.nextLine();

                    Profissional contaProfissional = new Profissional(nome, idade, profissao);

                    System.out.print("Digite seu novo nome de usuario: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite seu novo email: ");
                    String email = ler.nextLine();
                    System.out.print("Digite sua nova senha: ");
                    String senha = ler.nextLine();

                    Utilizador<Profissional> utilizadorNovo = new Utilizador<>(nomeUsuario, email, senha, contaProfissional);

                    boolean atualizacao = autenticacaoController.atualizarUtilizador(nomeUsuarioAtual, senhaAtual, utilizadorNovo);

                    if (atualizacao) {
                        System.out.println("=-=- ATUALIZACAO REALIZADA COM SUCESSO -=-=");
                    } else {
                        System.out.println("=-=- ATUALIZACAO NÃO REALIZADA -=-=");
                    }

                } else {
                    throw new OptionException();
                }
            }
            else if (op.equals("0")) {
                System.out.println("-=-= SAIR =-=-");
                break;
            } else {
                throw new OptionException();
            }
        }
    }
}
