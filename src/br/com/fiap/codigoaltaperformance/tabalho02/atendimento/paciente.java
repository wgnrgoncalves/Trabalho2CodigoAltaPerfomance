package br.com.fiap.codigoaltaperformance.tabalho02.atendimento;

public class paciente {
	private String nome;
	private long cpf;
	private int sintoma;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public int getSintoma() {
		return sintoma;
	}
	public void setSintoma(int sintoma) {
		this.sintoma = sintoma;
	}
	
	public String toString(){
		return "CPF: " + cpf + ". Nome: " + nome + ". Sintoma: " + Estatico.sintomas[sintoma];
	}
	

}
