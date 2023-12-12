package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class SimuladorBancario {
    private static ArrayList<Conta> contas = new ArrayList<>();
    private static int proximoNumeroConta = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n==== Menu ====");
        System.out.println("1. Cadastrar conta Poupança");
        System.out.println("2. Cadastrar conta Corrente");
        System.out.println("3. Excluir conta");
        System.out.println("4. Sacar");
        System.out.println("5. Depositar");
        System.out.println("6. Solicitar empréstimo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarContaPoupanca();
                break;
            case 2:
                cadastrarContaCorrente();
                break;
            case 3:
                excluirConta();
                break;
            case 4:
                realizarSaque();
                break;
            case 5:
                realizarDeposito();
                break;
            case 6:
                solicitarEmprestimo();
                break;
            case 0:
                System.out.println("Saindo do simulador bancário.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void cadastrarContaPoupanca() {
        System.out.print("Informe o nome do titular: ");
        String titular = scanner.next();
        ContaPoupanca novaContaPoupanca = new ContaPoupanca(proximoNumeroConta, titular);
        contas.add(novaContaPoupanca);
        System.out.println("Conta poupança cadastrada com sucesso. Número da conta: " + proximoNumeroConta);
        proximoNumeroConta++;
    }

    private static void cadastrarContaCorrente() {
        System.out.print("Informe o nome do titular: ");
        String titular = scanner.next();
        System.out.print("Informe o limite do cheque especial: ");
        double limiteChequeEspecial = scanner.nextDouble();
        ContaCorrente novaContaCorrente = new ContaCorrente(proximoNumeroConta, titular, limiteChequeEspecial);
        contas.add(novaContaCorrente);
        System.out.println("Conta corrente cadastrada com sucesso. Número da conta: " + proximoNumeroConta);
        proximoNumeroConta++;
    }

    private static void excluirConta() {
        System.out.print("Informe o número da conta a ser excluída: ");
        int numeroConta = scanner.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            if (conta.getSaldo() > 0) {
                conta.sacar(conta.getSaldo());
            }

            contas.remove(conta);
            System.out.println("Conta excluída com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarSaque() {
        System.out.print("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Informe o valor para saque: ");
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarDeposito() {
        System.out.print("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Informe o valor para depósito: ");
            double valorDeposito = scanner.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void solicitarEmprestimo() {
        System.out.print("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Informe o valor do empréstimo: ");
            double valorEmprestimo = scanner.nextDouble();
            conta.solicitarEmprestimo(valorEmprestimo);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}