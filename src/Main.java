import java.util.List;

public class Main {

	public static void main(String[] args) {
        Cliente venilton = new Cliente("Venilton");

        Banco banco = new Banco("Meu Banco");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(200);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.pagarComCartaoCredito(10);
        cc.imprimirExtratoDetalhado();
        System.out.println("Saldo disponível na conta corrente: " + ((ContaCorrente) cc).verificarSaldoDisponivel());

    }
}	


