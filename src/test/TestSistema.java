package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entities.Cliente;
import entities.Funcionario;
import entities.Loja;

class TestSistema {

	@Test
	void saldoInicialCliente() {
		Cliente cl = new Cliente();
		assertEquals(1000, cl.getConta().getSaldo());
	}
	
	@Test
	void clienteRealizaCompras() {
		Cliente cl = new Cliente();
		Loja lo1 = new Loja();
		Loja lo2 = new Loja();
		
		cl.fazerCompra(lo1, 100);
		cl.fazerCompra(lo2, 200);
		cl.fazerCompra(lo2, 100);
		cl.fazerCompra(lo1, 200);
		cl.fazerCompra(lo1, 100);
		cl.fazerCompra(lo2, 200);
		cl.fazerCompra(lo1, 100);
		
		assertEquals(0, cl.getConta().getSaldo());
		
	}
	
	@Test
	void verificarSalarioFuncionario() {
		Cliente cl = new Cliente();
		Loja lo = new Loja();
		
		cl.fazerCompra(lo, 2800);
		
		Funcionario fu = lo.getFuncionarios().get(0);
		lo.testPagamento();
		
		double valorInvestido = fu.getInvestimento().getSaldo();
		double valorSalario = fu.getSalario().getSaldo();
		assertEquals(280, valorInvestido);
		assertEquals(1120, valorSalario);
		
	}
	
	@Test
	void comprarEmVariasLojas() {
		Cliente cl = new Cliente();
		Loja lo = new Loja();
		Loja lo2 = new Loja();
		
		ArrayList<Loja> loja = new ArrayList<>();
		
		loja.add(lo);
		loja.add(lo2);
		cl.setLojas(loja);
		cl.fazerCompras();
		
		assertEquals(0, cl.getConta().getSaldo());
		assertTrue(lo.getConta().getSaldo() != 0);
		assertTrue(lo2.getConta().getSaldo() != 0);
	}
}

