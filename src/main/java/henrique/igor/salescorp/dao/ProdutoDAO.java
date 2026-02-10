package henrique.igor.salescorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import henrique.igor.salescorp.jdbc.ConnectionFactory;
import henrique.igor.salescorp.model.ProdutoVO;

public class ProdutoDAO {
	
	public void salvar(ProdutoVO produto) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TGFPRO (CODPROD, DESCRPROD, VLRVENDA, ATIVO) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
			
			stmt.setInt(1, produto.getCodProd());
			stmt.setString(2, produto.getDescrProd());
			stmt.setBigDecimal(3, produto.getVlrVenda());
			stmt.setString(4, produto.getAtivo());
			
			stmt.executeUpdate();
			System.out.println("Produto inserido com sucesso: " + produto.getCodProd());
			
		} catch (SQLException e) {
			System.err.println("Erro ao salvar produto: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<ProdutoVO> listarTodos(){
		List<ProdutoVO> lista = new ArrayList<>();
		String sql = "SELECT CODPROD, DESCRPROD, VLRVENDA, ATIVO FROM TGFPRO ORDER BY CODPROD";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()){
			
			while(rs.next()) {
				ProdutoVO prod = new ProdutoVO();
				
				prod.setCodProd(rs.getInt("CODPROD"));
				prod.setDescrProd(rs.getString("DESCRPROD"));
				prod.setVlrVenda(rs.getBigDecimal("VLRVENDA"));
				prod.setAtivo(rs.getString("ATIVO"));
				
				lista.add(prod);		
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao listar produtos: " + e.getMessage());
			e.printStackTrace();
		}
		
		return lista;
	}

}
