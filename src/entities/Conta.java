package entities;

import java.util.Scanner;

public abstract class Conta {

	private static final int AGENCIA = 1;
	private static int NUMERO = 1;

	protected int agencia;
	protected int numero;
	protected double saldo = 0.0;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = AGENCIA;
		this.numero = NUMERO++;
	}

	public Cliente getCliente() {
		return cliente;
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

	public double limiteSaque() {
		double limite = saldo / 2;
		return limite;
	}

	public void validarSaque(double valor) {
		if (valor > saldo) {
			throw new IllegalStateException("Valor maior que o saldo.");
		}
		if (valor > limiteSaque()) {
			throw new IllegalStateException(
					"Valor maior que o limite permitido, valor permitido: " + String.format("%.2f", limiteSaque()));
		}
	}

	public void validarTransferencia(double valor) {
		if (valor > saldo) {
			throw new IllegalStateException(
					"Operacao nao permitida, valor maior que o saldo -- Saldo: " + String.format("%.2f", saldo));
		}
	}

	public void operacaoConta(Scanner sc, Conta conta) {
		System.out.println("Deposito[1], Saque[2], Transferencia[3], Sair[4]");
		int opcaoOperacao = sc.nextInt();

		if (opcaoOperacao == 1) {
			System.out.println("Quantia para deposito: ");
			double valor = sc.nextDouble();
			conta.deposito(valor);
		} else if (opcaoOperacao == 2) {
			System.out.println("Quantia para saque: ");
			double valor = sc.nextDouble();
			conta.saque(valor);
		} else if (opcaoOperacao == 3) {
			System.out.println("Quantia para transferencia: ");
			double valor = sc.nextDouble();
			conta.transferencia(valor, conta);
		} else if (opcaoOperacao == 4) {
			return;
		} else {
			System.out.println("Operacao desconhecida");
		}
	}

	public abstract void imprimirExtrato();

	public void saque(double valor) {
		validarSaque(valor);
		saldo -= valor;
	}

	public void deposito(double valor) {
		saldo += valor;

	}

	public void transferencia(double valor, Conta contaDestino) {
		validarTransferencia(valor);
		this.saque(valor);
		contaDestino.deposito(valor);

	}
}
