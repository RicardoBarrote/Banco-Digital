package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Banco banco = new Banco();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Criar conta[1], Terminar programa[2]");
			int operacao = sc.nextInt();

			while (operacao != 2) {
				System.out.println("===CADASTRO CLIENTE===");
				System.out.println();
				System.out.print("Nome: ");
				sc.nextLine();
				String nomeTitular = sc.nextLine();
				System.out.print("Data de nascimento (DIA/MES/ANO): ");
				Date data = sdf.parse(sc.next());
				Cliente cliente = new Cliente(nomeTitular, data);
				
				System.out.println();
				System.out.println("Cadastro realizado! ");
				System.out.println("Dados: ");
				System.out.println(cliente);

				System.out.println();
				System.out.println("---------------------------------");
				System.out.println();

				Conta contacorrente = new ContaCorrente(cliente);
				Conta contapoupanca = new ContaPoupanca(cliente);

				banco.adicionarContatoNaLista(contapoupanca);
				banco.adicionarContatoNaLista(contacorrente);

				System.out.println("Contas criadas!");
				System.out.println();

				banco.imprimirLista();

				System.out.println();
				System.out.println("---------------------------------");
				System.out.println();

				System.out.println("== OPERACAO CONTA POUPANCA==");
				contapoupanca.operacaoConta(sc, contapoupanca);
				
				System.out.println();

				System.out.println("== OPERACAO CONTA CORRENTE==");
				contacorrente.operacaoConta(sc, contacorrente);
				
				System.out.println();
				banco.imprimirLista();

				System.out.println("Criar conta[1], Terminar programa[2]");
				operacao = sc.nextInt();
			}
			
			banco.imprimirLista();

		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}

}
