package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String nome;
	private String cpf;
	private Date data;

	public Cliente(String nome, Date data) {
		this.nome = nome;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String toString() {
		return "Nome: " + nome
				+", Data de nascimento: (DIA/MES/ANO): "
				+ sdf.format(data);
	}

}
