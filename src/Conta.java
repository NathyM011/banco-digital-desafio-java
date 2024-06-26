
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    // Adicionando funcionalidades de Cartão de Crédito
    private double limiteCredito = 100.0;
    private double saldoCartaoCredito = 0.0;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getSaldoCartaoCredito() {
        return saldoCartaoCredito;
    }

    public void pagarComCartaoCredito(double valor) {
        if (valor <= saldoCartaoCredito) {
            saldoCartaoCredito -= valor;
            System.out.println("Pagamento de R$" + valor + " realizado com sucesso utilizando o cartão de crédito.");
        } else {
            System.out.println("Saldo insuficiente no cartão de crédito.");
        }
    }

    public void verificarSaldoCartaoCredito() {
        System.out.println("Saldo disponível no cartão de crédito: R$" + saldoCartaoCredito);
    }

    // Implementação do extrato detalhado
    @Override
    public void imprimirExtratoDetalhado() {
        System.out.println("=== Extrato Detalhado ===");
        System.out.println("Transações realizadas:");
        // Lógica para imprimir todas as transações realizadas
    }
}