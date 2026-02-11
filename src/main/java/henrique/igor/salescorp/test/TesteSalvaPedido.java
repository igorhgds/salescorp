package henrique.igor.salescorp.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import henrique.igor.salescorp.dao.PedidoDAO;
import henrique.igor.salescorp.model.PedidoVO;

public class TesteSalvaPedido {

	public static void main(String[] args) {
		PedidoDAO dao = new PedidoDAO();
		
		System.out.println("=== INSERINDO NOVO PEDIDO ===");
		PedidoVO novoPedido = new PedidoVO(1, LocalDate.of(2026, 2, 11), 1 ,new BigDecimal("200.00"), "P");
		dao.salvarCabecalho(novoPedido);
		
		System.out.println("Pedido salvo com NUNOTA: " + novoPedido.getNuNota());
	}
}
