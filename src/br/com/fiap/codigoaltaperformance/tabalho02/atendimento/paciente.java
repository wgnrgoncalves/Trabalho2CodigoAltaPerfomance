package br.com.fiap.codigoaltaperformance.tabalho02.atendimento;

public class paciente {
	private String nome;
	private long cpf;
	private FilaEncadeadaSintoma sintoma;
	public paciente() {
		this.sintoma = new FilaEncadeadaSintoma();
		this.sintoma.init();
	}
	
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
	public FilaEncadeadaSintoma getSintoma() {
		return sintoma;
	}
//	public void setSintoma(FilaEncadeadaSintoma sintoma) {
//		this.sintoma = FilaEncadeadaSintoma;
//	}
	
	public String toString(){
		return "CPF: " + cpf + ". Nome: " + nome;
	}
	

}
