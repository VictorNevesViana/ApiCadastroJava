package br.com.cadastroRestaurante.factory;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cadastro";
	private static final String USUARIO = "root";
	private static final String SENHA = "140593vi";
	
	
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try{
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		}catch ( Exception e){
			System.out.println("Erro ao criar conex�o com o banco:" + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	public void fecharConexao(Connection conexao,PreparedStatement pstmt, ResultSet rs){
		
		try{
			
			if(conexao != null){
				conexao.close();
			}
			
			if(pstmt != null){
				pstmt.close();
			}
			
			if(rs !=null){
				rs.close();
			}
		}catch(Exception e){
			System.out.println("Erro ao fechar conex�o com o banco" + URL);
		}
		
		
	}
	
}
