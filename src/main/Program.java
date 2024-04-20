package main;

import java.util.ArrayList;

import entities.Banco;
import entities.Cliente;
import entities.Loja;

public class Program extends Thread {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Loja loja1 = new Loja(banco);
		Loja loja2 = new Loja(banco);
		
		ArrayList<Loja> lojas = new ArrayList<>();
		
		lojas.add(loja1);
		lojas.add(loja2);
		
		Cliente cliente1 = new Cliente("victor",lojas,banco);
		Cliente cliente2 = new Cliente("mariana",lojas,banco);
		Cliente cliente3 = new Cliente("lara",lojas,banco);
		Cliente cliente4 = new Cliente("caio",lojas,banco);
		Cliente cliente5 = new Cliente("amanda",lojas,banco);
		
		cliente1.start();
		cliente2.start();
		cliente3.start();
		cliente4.start();
		cliente5.start();
		
		try {
			cliente1.join();
			cliente2.join();
			cliente3.join();
			cliente4.join();
			cliente5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n-CONTA DOS FUNCIONÁRIOS- ");
		
		System.out.printf("SALDO DOS FUNCIONARIOS DA LOJA 1: \nSalário: R$ %.2f\nInvestimento: R$ %.2f\n\n",
				loja1.getFuncionarios().get(0).getSalario().getSaldo(),
				loja1.getFuncionarios().get(0).getInvestimento().getSaldo());
		System.out.printf("SALDO DOS FUNCIONARIOS DA LOJA 2: \nSalário: R$ %.2f\nInvestimento: R$ %.2f\n\n",
				loja2.getFuncionarios().get(0).getSalario().getSaldo(),
				loja2.getFuncionarios().get(0).getInvestimento().getSaldo());
		
		System.out.println("\n-CONTA DAS LOJAS- ");
		
		System.out.printf("SALDO DA LOJA 1: R$ %.2f\n",
				loja1.getConta().getSaldo());
		System.out.printf("SALDO DA LOJA 2: R$ %.2f\n",
				loja2.getConta().getSaldo());
		
		System.out.println("\n-CONTA DOS CLIENTES- ");
		
		System.out.println(cliente1);
		System.out.println(cliente2);
		System.out.println(cliente3);
		System.out.println(cliente4);
		System.out.println(cliente5);
	}
}
