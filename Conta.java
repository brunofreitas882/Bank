package Entities;

class Conta {
    private int numero;
    private String tipo;
    private String titular;
    private double saldo;

    public Conta(int numero, String tipo, String titular) {
        this.numero = numero;
        this.tipo = tipo;
        this.titular = titular;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
        }
    }

    public void solicitarEmprestimo(double valor) {
        double limiteEmprestimo = (tipo.equals("PF")) ? 2000 : 5000;

        if (saldo + limiteEmprestimo >= valor) {
            saldo += valor;
            System.out.println("Empréstimo de R$" + valor + " aprovado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Empréstimo não aprovado. Valor excede o limite disponível.");
        }
    }
}
