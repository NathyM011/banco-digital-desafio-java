
public class ContaCorrente extends Conta {
	private double limiteChequeEspecial = 200.0; // Limite inicial do cheque especial
	
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    // Método para verificar saldo disponível na conta corrente, incluindo o cheque especial
    public double verificarSaldoDisponivel() {
        return this.saldo + limiteChequeEspecial;
    }
	
}