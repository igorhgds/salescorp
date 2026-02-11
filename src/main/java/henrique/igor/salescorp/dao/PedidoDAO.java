package henrique.igor.salescorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import henrique.igor.salescorp.jdbc.ConnectionFactory;
import henrique.igor.salescorp.model.PedidoVO;

public class PedidoDAO {
	
	public Integer salvarCabecalho(PedidoVO pedido) {
		String sql = "INSERT INTO TGFCAB (NUMNOTA, DTNEG, CODPARC, VLRNOTA, STATUS) VALUES (?, ?, ?, ?, ?)";
		Integer idGerado = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, new String[] { "NUNOTA" })){
			
			stmt.setInt(1, pedido.getNumNota());
			stmt.setDate(2, Date.valueOf(pedido.getDtNeg()));
			stmt.setInt(3, pedido.getCodParc());
			stmt.setBigDecimal(4, pedido.getVlrNota());
            stmt.setString(5, "P");
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        pedido.setNuNota(idGerado);
                    }
                }
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Não foi possível salvar o cabeçalho");
		}
		
		return idGerado;
	}

}
