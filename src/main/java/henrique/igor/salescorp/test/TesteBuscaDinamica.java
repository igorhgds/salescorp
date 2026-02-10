package henrique.igor.salescorp.test;

import java.util.List;

import henrique.igor.salescorp.dao.ParceiroDAO;
import henrique.igor.salescorp.model.ParceiroVO;

public class TesteBuscaDinamica {

	public static void main(String[] args) {
		ParceiroDAO dao = new ParceiroDAO();

        System.out.println("--- CENÁRIO 1: Busca apenas por 'Silva' ---");
        List<ParceiroVO> resultado1 = dao.buscarPorFiltro("Silva", null);
        resultado1.forEach(System.out::println);

        System.out.println("\n--- CENÁRIO 2: Busca por Tipo 'J' (Jurídica) ---");
        List<ParceiroVO> resultado2 = dao.buscarPorFiltro(null, "J");
        resultado2.forEach(System.out::println);
        
        System.out.println("\n--- CENÁRIO 3: Busca Vazia (Deve trazer tudo) ---");
        List<ParceiroVO> resultado3 = dao.buscarPorFiltro(null, null);
        System.out.println("Total encontrados: " + resultado3.size());
    }

}