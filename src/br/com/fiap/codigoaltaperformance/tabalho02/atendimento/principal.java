package br.com.fiap.codigoaltaperformance.tabalho02.atendimento;

import java.io.FileInputStream;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		FilaEncadeada filaAtendimento = new FilaEncadeada();
		FilaEncadeada filaInternacao = new FilaEncadeada();
		long[] leitoInternacao = null;
		paciente p;
		filaAtendimento.init();
		filaInternacao.init();
		int opcao;

		String nome;
		long cpf;

		/*
		 * Tosse Febre Cansaço Dificuldade para respirar (em casos graves)
		 */
		do {
			System.out.println("Informe a quantidade de leitos");
			opcao = teclado.nextInt();

		} while (opcao < 0);

		leitoInternacao = new long[opcao];
		opcao = 0;
		// teclado.next();

		do {
			System.out.println(
					"Informe uma opção 0 - Sair, 1 - Colocar paciente na fila, 2 - Atender paciente, 3 - Aplicar alta para paciente");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				p = new paciente();

				System.out.print("Informe o nome do paciente:");
				nome = teclado.next();
				p.setNome(nome);

				System.out.print("Informe o cpf:");
				cpf = teclado.nextLong();
				p.setCpf(cpf);

				filaAtendimento.enqueue(p);

				break;
			case 2:
				System.out.println("Atender paciente da fila");
				if (!filaAtendimento.isEmpty()) {
					p = filaAtendimento.dequeue();
					System.out.println("Informe o sintoma:\n" + ListSintomas(Estatico.sintomas));
					int sintoma = teclado.nextInt();
					p.setSintoma(sintoma);

					if (p.getSintoma() > 0) {
						boolean havagas = false;
						for (int i = 0; i < leitoInternacao.length; i++) {
							if (leitoInternacao[i] == 0) {
								leitoInternacao[i] = p.getCpf();
								havagas = true;
								System.out.println("Internando o paciente " + p + " no leito " + i);
								break;
							}
						}

						if (!havagas) {
							filaInternacao.enqueue(p);
							System.out.println(
									"Não há leitos vagos. Inserindo paciente " + p + " na lista de internação");

						}
					} else {
						System.out.println("Paciente: " + p + ". Será liberado");
					}

					// System.out.println("O paciente a ser atendido: " + p);
				} else {
					System.out.println("Não tem pacientes na fila");

				}

				break;
			case 3:
				System.out.println("Informe o CPF que deseja aplicar a alta: ");
				cpf = teclado.nextLong();
				boolean encontrou = false;
				for (int i = 0; i < leitoInternacao.length; i++) {
					if (leitoInternacao[i] == cpf) {
						leitoInternacao[i] = 0;
						System.out.println("Paciente: " + cpf + ". Recebeu alta. Leito " + i + " foi desoculpado.");

						if (!filaInternacao.isEmpty()) {
							p = filaInternacao.dequeue();
							leitoInternacao[i] = p.getCpf();
							System.out.println(
									"Pacienete " + p + " que esta na fila de internação foi internado no leito: " + i);
						}
						encontrou = true;
						break;
					}
					;

				}
				if (!encontrou) {
					System.out.println("Não econtrou o paciente: " + cpf);
				}

				break;
			default:
				if (!filaAtendimento.isEmpty()) {
					System.out.println("Há pacientes na fila, deseja");
					while (!filaAtendimento.isEmpty()) {
						System.out.println(filaAtendimento.dequeue());
					}
				}

				opcao = 0;

			}
		} while (opcao > 0);

		teclado.close();
	}

	private static String ListSintomas(String[] sintomas) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sintomas.length; i++) {
			sb.append(i + " - " + sintomas[i] + "\n");

		}
		return sb.toString();
	}

}
