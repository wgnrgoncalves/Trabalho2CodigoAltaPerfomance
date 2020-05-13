package br.com.fiap.codigoaltaperformance.tabalho02.atendimento;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		FilaEncadeada2 fila = new FilaEncadeada2();
		paciente p;
		fila.init();
		int opcao;

		/*
		 * Tosse Febre Cansaço Dificuldade para respirar (em casos graves)
		 */
		do {
			System.out.println("Informe uma opção 0 - Sair, 1 - Colocar paciente na fila, 2 - Atender paciente");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				p = new paciente();

				System.out.println("Informe o nome do paciente");
				String nome = teclado.next();
				p.setNome(nome);

				System.out.println("Informe o cpf");
				long cpf = teclado.nextLong();
				p.setCpf(cpf);

				fila.enqueue(p);

				break;
			case 2:

				System.out.println("Atender paciente da fila");
				if (!fila.isEmpty()) {
					p = fila.first();
					System.out.println("Infomre o sintoma:\n " + ListSintomas(Estatico.sintomas));
					int sintoma = teclado.nextInt();
					p.setSintoma(sintoma);
					System.out.println("O paciente a ser atendido: " + p);
				} else {
					System.out.println("Não tem pacientes na fila");

				}

				break;
			default:
				if (!fila.isEmpty()) {
					System.out.println("Há pacientes na fila, deseja");
					while (!fila.isEmpty()) {
						System.out.println(fila.dequeue());
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
