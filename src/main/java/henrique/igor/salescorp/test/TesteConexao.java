package henrique.igor.salescorp.test;

import java.sql.Connection;

import henrique.igor.salescorp.jdbc.ConnectionFactory;

public class TesteConexao {
	public static void main(String[] args) {
		System.out.println("Tentando conectar ao Oracle DB...");
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			if(conn != null) {
				System.out.println("SUCESSO! Conexão estabelecida com o usuário SALES_ORDER_SYSTEM.");
				System.out.println("Driver: " + conn.getMetaData().getDriverName());
			} else {
				System.out.println("Falha: Conexão veio nula.");
			}
			
		} catch (Exception e) {
			System.err.println("ERRO CRÍTICO DE CONEXÃO:");
            e.printStackTrace();
		}
	}

}
