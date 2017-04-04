package br.com.cadastroRestaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.cadastroRestaurante.factory.ConnectionFactory;
import br.com.cadastroRestaurante.model.Cliente;

public class ClienteDao extends ConnectionFactory{
	
	private static ClienteDao instance;
	
	public static ClienteDao getInstance(){
		if(instance == null)
			instance = new ClienteDao();
		return instance;
	}
	

	public ArrayList<Cliente> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;
		
		conexao = criarConexao();
		clientes = new ArrayList<Cliente>();
		
		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setSite(rs.getString("site"));
				cliente.setDescricao(rs.getString("descricao"));
				
				clientes.add(cliente);
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes:" + e);
			e.printStackTrace();
		}finally{
			fecharConexao(conexao, pstmt, rs);
		}
		
		return clientes;
	}
}
