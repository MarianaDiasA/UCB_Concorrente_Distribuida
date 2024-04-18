package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Banco;
import entities.Cliente;
import entities.Funcionario;
import entities.Loja;

class TestSistema {

	@Test
	void saldoInicialCliente() {
		Cliente cl = new Cliente();
		assertEquals(1000, cl.getSaldo());
	}
	
	@Test
	void clienteRealizaCompras() {
		Cliente cl = new Cliente();
		Banco bc = new Banco();
		Loja lo1 = new Loja();
		Loja lo2 = new Loja();
		
		cl.setBanco(bc);
		cl.fazerCompra(lo1, 100);
		cl.fazerCompra(lo2, 200);
		cl.fazerCompra(lo2, 100);
		cl.fazerCompra(lo1, 200);
		cl.fazerCompra(lo1, 100);
		cl.fazerCompra(lo2, 200);
		cl.fazerCompra(lo1, 100);
		
		assertEquals(0, cl.getSaldo());
		
	}
	
	@Test
	void verificarSalarioFuncionario() {
		Cliente cl = new Cliente();
		Banco bc = new Banco();
		Loja lo = new Loja();
		
		cl.setBanco(bc);
		cl.fazerCompra(lo, 2800);
		
		Funcionario fu = lo.getFuncionarios().get(0);
		lo.testPagamento();
		
		double valorInvestido = fu.getInvestimento().getSaldo();
		double valorSalario = fu.getSalario().getSaldo();
		assertEquals(280, valorInvestido);
		assertEquals(1120, valorSalario);
		
	}

}

