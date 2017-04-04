package br.com.cadastroRestaurante.controler;

import java.util.ArrayList;

import br.com.cadastroRestaurante.dao.ClienteDao;
import br.com.cadastroRestaurante.model.Cliente;

public class ClienteControler {
	
	public ArrayList<Cliente> listarTodos(){
		
		return ClienteDao.getInstance().listarTodos();
	}

}
