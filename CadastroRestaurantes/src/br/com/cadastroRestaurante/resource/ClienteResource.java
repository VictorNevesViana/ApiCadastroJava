package br.com.cadastroRestaurante.resource;




import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.com.cadastroRestaurante.controler.ClienteControler;
import br.com.cadastroRestaurante.model.Cliente;

@Path("/cliente")
public class ClienteResource {
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public String listarTodos(){
		ArrayList<Cliente> controler = new ClienteControler().listarTodos();
		
		return new Gson().toJson(controler);
		
	}
	
}
