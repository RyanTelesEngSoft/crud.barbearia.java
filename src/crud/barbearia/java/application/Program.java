package crud.barbearia.java.application;

import java.util.Scanner;

import crud.barbearia.java.model.Agendamento;
import crud.barbearia.java.model.Cliente;
import crud.barbearia.java.model.Servico;
import crud.barbearia.java.model.ServicoCatalogo;
import crud.barbearia.java.service.Sistema;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Sistema sistema = new Sistema();
	
		int opcao;
		do{
			System.out.println("\n----------Opções---------\n");
			System.out.println("1 - Criar Agendamento");
			System.out.println("2 - Listar todos os agendamentos");
			System.out.println("3 - Deletar");
			System.out.println("4 - Atualizar");
			System.out.println("\n----------------------------\n");
			
			System.out.print("Digite a opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			
		
			case 1: 
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();
				
				Cliente cliente = new Cliente(nome, email, telefone);
				
				System.out.println("Escolha seu Serviço: Corte/Barba/Combo");
				String escolhaServico = sc.nextLine();
				
				
				Servico servicoEscolhido = null;
				escolhaServico = escolhaServico.trim().toLowerCase();
				
			

				for (Servico s : ServicoCatalogo.lista) {
					  if (s.getNome().toLowerCase().equals(escolhaServico)) {
				        servicoEscolhido = s;
				        break;
				    }
					
				}
				if (servicoEscolhido == null) {
				    System.out.println("Serviço inválido!");
				    break;
				}
			
				System.out.println("Qual horario do agendamento? ");
				int hora = sc.nextInt();
				sc.nextLine();
			
				
				Agendamento ag = new Agendamento( servicoEscolhido, cliente, hora);
				sistema.adicionarAgendamento(ag);
				System.out.println("Adicionado!");
				break;
			
			case 2:
				System.out.println("\n---------Agendamentos---------\n");
				sistema.listarAgendamento();
				System.out.println("\n-------------------------------\n");
				break;
		
			case 3: 
				System.out.println("\n--- AGENDAMENTOS ---");
				sistema.listarAgendamento();
				System.out.println("Digite o indice para deletar um agendamento: ");
				int indice = sc.nextInt();
				sistema.removerAgendamento(indice);
				break;
				
			
			case 4:
			    System.out.println("\n--- AGENDAMENTOS ---");
			    sistema.listarAgendamento();

			    System.out.print("Digite o índice para atualizar: ");
			    int indiceAtualizar = sc.nextInt();
			    sc.nextLine();

			    // NOVOS DADOS DO CLIENTE
			    System.out.print("Novo nome: ");
			    String nomeNovo = sc.nextLine();

			    System.out.print("Novo email: ");
			    String emailNovo = sc.nextLine();

			    System.out.print("Novo telefone: ");
			    String telefoneNovo = sc.nextLine();

			    Cliente clienteNovo = new Cliente(nomeNovo, emailNovo, telefoneNovo);

			    // MENU DE SERVIÇOS
			    System.out.println("\nEscolha o novo serviço:");
			    System.out.println("1 - Corte");
			    System.out.println("2 - Barba");
			    System.out.println("3 - Combo");
			    System.out.print("Opção: ");

			    int opcaoServico = sc.nextInt();
			    sc.nextLine();

			    Servico servicoEs = null;

			    if (opcaoServico >= 1 && opcaoServico <= ServicoCatalogo.lista.size()) {
			        servicoEscolhido = ServicoCatalogo.lista.get(opcaoServico - 1);
			    } else {
			        System.out.println("Opção inválida!");
			        break;
			    }

			    // NOVO HORÁRIO
			    System.out.print("Novo horário: ");
			    int novaHora = sc.nextInt();
			    sc.nextLine();

			    // CRIA NOVO AGENDAMENTO
			    Agendamento novoAg = new Agendamento(servicoEscolhido, clienteNovo, novaHora);

			    // ATUALIZA
			    sistema.atualizarAgendamento(indiceAtualizar, novoAg);
			    break;
			
			}
			
			
		}while(opcao != 0);
		
	
		sc.close();
	}
	

}
