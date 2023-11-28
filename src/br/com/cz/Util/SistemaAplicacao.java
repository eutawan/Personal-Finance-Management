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
        System.out.print("\t-=-= INVESTIMENTO =-=-\n" +
                "1 - ADICIONAR DESPESA\n" +
                "2 - ADICONAR RENDA\n" +
                "3 - ADICONAR TRANSFERENCIA\n" +
                "0 - VOLTAR\n" +
                "OPÇÃO: ");
        Scanner ler = new Scanner(System.in);
        String op = ler.nextLine();
        return op;
    }
}