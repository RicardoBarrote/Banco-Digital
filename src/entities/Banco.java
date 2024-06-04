package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	
	
	private List<Conta> listBanco = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getListBanco() {
		return listBanco;
	}

	public void adicionarContatoNaLista(Conta conta) {
		listBanco.add(conta);
	}

	public void tamanhoListaContato() {
		System.out.println(listBanco.size());
	}

	public void removerContatoNaLista(Conta conta) {
		List<Conta> removerConta = new ArrayList<Conta>();

		if (!listBanco.isEmpty()) {
			removerConta.add(conta);
			listBanco.removeAll(removerConta);
		} else {
			throw new IllegalStateException("Sua lista esta vazia. ");
		}

	}

	public void imprimirLista() {
		if (!listBanco.isEmpty()) {
			for (Conta conta : listBanco) {
				conta.imprimirExtrato();
				System.out.println();
			}
		} else {
			throw new IllegalStateException("Sua lista esta vazia. ");
		}

	}
}
