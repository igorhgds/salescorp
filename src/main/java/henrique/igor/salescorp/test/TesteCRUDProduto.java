package henrique.igor.salescorp.test;

import java.math.BigDecimal;
import java.util.List;

import henrique.igor.salescorp.dao.ProdutoDAO;
import henrique.igor.salescorp.model.ProdutoVO;

public class TesteCRUDProduto {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		
		System.out.println("=== INSERINDO NOVO PRODUTO ===");
        ProdutoVO novoProduto = new ProdutoVO(102, "Monitor 24pol", new BigDecimal("800.00"), "S");
        dao.salvar(novoProduto);
        
        System.out.println("\n=== LISTANDO TODOS OS PRODUTOS ===");
        List<ProdutoVO> produtos = dao.listarTodos();
        
        produtos.forEach(System.out::println);

	}

}
