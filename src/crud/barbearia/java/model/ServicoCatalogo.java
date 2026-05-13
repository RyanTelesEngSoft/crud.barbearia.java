package crud.barbearia.java.model;

import java.util.ArrayList;
import java.util.List;

public class ServicoCatalogo {

	
	public static List<Servico> lista = new ArrayList<>();
	
	static {
		lista.add(new Servico("Corte",35.00));
		lista.add(new Servico("Barba",30.00));
		lista.add(new Servico("Combo",50.00));
	}
}
