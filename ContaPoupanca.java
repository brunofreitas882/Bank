package Entities;

class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String titular) {
        super(numero, "Poupança", titular);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Saldo atual: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
        }
    }

    public void solicitarEmprestimo(double valor) {
        System.out.println("Empréstimo não disponível para conta poupança.");
    }
}
