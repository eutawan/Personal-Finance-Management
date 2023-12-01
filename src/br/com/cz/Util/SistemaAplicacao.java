package br.com.cz.Util;
import java.util.Scanner;

import br.com.cz.Controller.AutenticacaoController;

public class SistemaAplicacao {

    public SistemaAplicacao() {

    }

    public String menuInicial(){
        System.out.print("\t-=-= GERENCIAMENTO FINANÇAS PESSOAIS =-=-\n" +
                "1 - CRIAR CONTA\n" +
                "2 - FAZER LOGIN\n" +
                "3 - REMOVER CONTA\n" +
                "4 - ATUALIZAR CONTA\n" +
                "0 - SAIR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;

    }

    public String menuPrincipal() {
        System.out.print("\t-=-= SELECIONE O SISTEMA =-=-\n" +
                "1 - CONTAS BANCARIAS\n" +
                "2 - TRANSACOES\n" +
                "3 - INVESTIMENTOS\n" +
                "0 - SAIR DA CONTA\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuConta() {
        System.out.print("\t-=-= CONTAS BANCARIAS =-=-\n" +
                "1 - CADASTRAR CONTA\n" +
                "2 - MOSTRAR CONTAS\n" +
                "3 - REMOVER CONTA\n" +
                "4 - ATUALIZAR CONTA\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuInvestimento() {
        System.out.print("\t-=-= INVESTIMENTO =-=-\n" +
                "1 - FAZER INVESTIMENTO\n" +
                "2 - FAZER APORTE\n" +
                "3 - FAZER RESGATE\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuTransacao() {
        System.out.print("\t-=-= TRANSAÇÕES =-=-\n" +
                "1 - DESPESA\n" +
                "2 - RENDA\n" +
                "3 - TRANSFERENCIA\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuDespesa() {
        System.out.print("\t-=-= DESPESAS =-=-\n" +
                "1 - ADICIONAR DESPESA\n" +
                "2 - EDTIAR DESPESA\n" +
                "3 - REMOVER DESPESA\n" +
                "4 - LISTAR DESPESAS\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuRenda() {
        System.out.print("\t-=-= RENDAS =-=-\n" +
                "1 - ADICIONAR RENDA\n" +
                "2 - EDTIAR RENDA\n" +
                "3 - REMOVER RENDA\n" +
                "4 - LISTAR RENDAS\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
    public String menuTransfer() {
        System.out.print("\t-=-= TRANSFERÊNCIAS =-=-\n" +
                "1 - ADICIONAR TRANSFERÊNCIA\n" +
                "2 - EDTIAR TRANSFERÊNCIA\n" +
                "3 - REMOVER TRANSFERÊNCIA\n" +
                "4 - LISTAR TRANSFERÊNCIAS\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
}