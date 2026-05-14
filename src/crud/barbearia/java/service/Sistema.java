package crud.barbearia.java.service;

import java.util.ArrayList;
import java.util.List;

import crud.barbearia.java.model.Agendamento;

public class Sistema {

private  List<Agendamento> agendamentos = new ArrayList<>();
	
	public void adicionarAgendamento (Agendamento ag) {
		agendamentos.add(ag);
	}
	
	public void listarAgendamento () {
		if(agendamentos.isEmpty()) {
			System.out.println("Agendamento Vazio!");
		}
		else {
			for(int i =0; i<agendamentos.size();i++) {
				System.out.println(i + " - " + agendamentos.get(i));
			}
		}
	}
	
	public void removerAgendamento (int indice) {
		if(indice >= 0 && indice <agendamentos.size()) {
			agendamentos.remove(indice);
			System.out.println("Removido com sucesso!");
		}
		else {
			System.out.println("Indice invalido!");
		}
	}
	public void atualizarAgendamento(int indice, Agendamento novo) {
	    if (indice >= 0 && indice < agendamentos.size()) {
	        agendamentos.set(indice, novo);
	        System.out.println("Atualizado com sucesso!");
	    } else {
	        System.out.println("Índice inválido!");
	    }
	}
}
