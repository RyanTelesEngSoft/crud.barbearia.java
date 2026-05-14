package crud.barbearia.java.model;

public class Agendamento {

		private Servico servico;
		private Cliente cliente;
		private Integer hora;
		
		
		public Agendamento(Servico servico, Cliente cliente, Integer hora) {
			this.servico = servico;
			this.cliente = cliente;
			this.hora = hora;
		}


		public Servico getServico() {
			return servico;
		}


		public Cliente getCliente() {
			return cliente;
		}



		public Integer getHora() {
			return hora;
		}

		
		
	}


