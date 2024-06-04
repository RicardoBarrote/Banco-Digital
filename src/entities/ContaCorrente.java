package entities;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {

		System.out.println("===Extrato Conta Corrente ===");
		System.out.println("Titular: " + super.cliente.getNome());
		System.out.println("Agencia: " + super.agencia);
		System.out.println("Numero da conta: " + super.numero);
		System.out.println("Saldo: " + String.format("%.2f", super.saldo));
	}
}
