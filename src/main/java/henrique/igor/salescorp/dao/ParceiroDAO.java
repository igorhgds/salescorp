package henrique.igor.salescorp.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import henrique.igor.salescorp.jdbc.ConnectionFactory;
import henrique.igor.salescorp.model.ParceiroVO;

public class ParceiroDAO {

	public void salvar(ParceiroVO parceiro) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TGFPAR (CODPARC, NOMEPARC, TIPPESSOA) ");
		sql.append("VALUES (?, ?, ?) ");

		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

			stmt.setInt(1, parceiro.getCodParc());
			stmt.setString(2, parceiro.getnomeParc());
			stmt.setString(3, parceiro.gettipPessoa());

			stmt.executeUpdate();
			System.out.println("Parceiro inserido com sucesso: " + parceiro.getnomeParc());

		} catch (SQLException e) {
			System.err.println("Erro ao salvar parceiro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<ParceiroVO> listarTodos() {
		List<ParceiroVO> lista = new ArrayList<>();
		String sql = "SELECT CODPARC, NOMEPARC, TIPPESSOA FROM TGFPAR ORDER BY NOMEPARC";

		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				ParceiroVO p = new ParceiroVO();

				p.setCodParc(rs.getInt("CODPARC"));
				p.setNomeParc(rs.getString("NOMEPARC"));
				p.setTipPessoa(rs.getString("TIPPESSOA"));

				lista.add(p);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar parceiros: " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<ParceiroVO> buscarPorFiltro(String nome, String tipoPessoa){
		List<ParceiroVO> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		
		sql.append(" SELECT CODPARC, NOMEPARC, TIPPESSOA ");
	    sql.append(" FROM TGFPAR ");
	    sql.append(" WHERE 1=1 ");
		
		if (nome != null && !nome.trim().isEmpty()) {
			sql.append(" AND UPPER(NOMEPARC) LIKE UPPER(?) ");
	        params.add("%" + nome + "%");
		}
		
		if (tipoPessoa != null && !tipoPessoa.trim().isEmpty()) {
	        sql.append(" AND TIPPESSOA = ? ");
	        params.add(tipoPessoa);
	    }
		
		sql.append(" ORDER BY NOMEPARC ");
		
		System.out.println("DEBUG SQL GERADO: " + sql.toString());
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

		        for (int i = 0; i < params.size(); i++) {
		            stmt.setObject(i + 1, params.get(i));
		        }

		        try (ResultSet rs = stmt.executeQuery()) {
		            while (rs.next()) {
		                ParceiroVO p = new ParceiroVO();
		                p.setCodParc(rs.getInt("CODPARC"));
		                p.setNomeParc(rs.getString("NOMEPARC"));
		                p.setTipPessoa(rs.getString("TIPPESSOA"));
		                lista.add(p);
		            }
		        }

		    } catch (SQLException e) {
		        System.err.println("Erro na busca dinâmica: " + e.getMessage());
		        e.printStackTrace();
		    }

		    return lista;
		}
}
