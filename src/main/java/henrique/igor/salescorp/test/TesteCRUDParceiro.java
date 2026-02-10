package henrique.igor.salescorp.test;

import java.util.List;

import henrique.igor.salescorp.dao.ParceiroDAO;
import henrique.igor.salescorp.model.ParceiroVO;

public class TesteCRUDParceiro {

	public static void main(String[] args) {
		ParceiroDAO dao = new ParceiroDAO();
		
		System.out.println("=== INSERINDO NOVO PARCEIRO ===");
        ParceiroVO novoCliente = new ParceiroVO(3, "Padaria do Zé", "J");
        dao.salvar(novoCliente);
        
        System.out.println("\n=== LISTANDO TODOS OS PARCEIROS ===");
        List<ParceiroVO> parceiros = dao.listarTodos();
        
        parceiros.forEach(System.out::println);

	}

}
