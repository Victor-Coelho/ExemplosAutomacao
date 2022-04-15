package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.Funcionario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FuncionarioTest {

	private static Funcionario funcA;
	private static Funcionario funcB;
	private static Funcionario funcC;

	private static Funcionario funcD;

	private static Funcionario funcE;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.print("Configurando os testes ... ");
		
		funcA = new Funcionario("Fulano de Tal", "fulano@company.com", 5000, Funcionario.DESENVOLVEDOR);
		funcB = new Funcionario("Cicrano de Tel", "cicrano@company.com", 2500, Funcionario.GERENTE);
		funcC = new Funcionario("Beltrano de Til", "beltrano@company.com", 550, Funcionario.TESTADOR);
		funcD = new Funcionario("DBA Menor", "dba@company.com", 1900, Funcionario.DBA);
		funcE = new Funcionario("DBA Maior", "dba2@company.com", 2500, Funcionario.DBA);
		
		System.out.println("OK");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testes Finalizados");
	}

	@Test
	@Order(1)
	void testSalarioDesenvolvedorMaior3000() {

		try {
			assertEquals(funcA.calculaSalario(), 4000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioGerenteMenor5000() {

		try {
			assertEquals(funcB.calculaSalario(), 2000);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testSalarioTestadorMenor2000() {

		try {
			assertEquals(funcC.calculaSalario(), 467.5);
		} catch (Exception e) {
			System.out.println("Define o raio do cargo direito!");
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(3)
	void testFuncionarioSemCargo() {

		try {
			funcA.setCargo("");
			assertThrows(Exception.class, ()->{funcA.calculaSalario();}, "Cargo Indefinido!");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	@Test
	void testeDbaMenor() {
		try {
			assertEquals(1615, funcD.calculaSalario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testeDbaMaior() {
		try {
			assertEquals(2000, funcE.calculaSalario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
