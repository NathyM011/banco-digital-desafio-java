
public class ContaCorrente extends Conta {

	private double limiteCredito = 100.0;
    private double saldoCartaoCredito = 0.0;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getSaldoCartaoCredito() {
        return saldoCartaoCredito;
    }
	

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	// Método para pagar com o cartão de crédito
    public void pagarComCartaoCredito(double valor) {
        if (valor <= saldoCartaoCredito) {
            saldoCartaoCredito -= valor;
            System.out.println("Pagamento de R$" + valor + " realizado com sucesso utilizando o cartão de crédito.");
        } else {
            System.out.println("Saldo insuficiente no cartão de crédito.");
        }
    }

	// Método para verificar saldo disponível no cartão de crédito
	public void verificarSaldoCartaoCredito() {
        System.out.println("Saldo disponível no cartão de crédito: R$" + saldoCartaoCredito);
    }

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}