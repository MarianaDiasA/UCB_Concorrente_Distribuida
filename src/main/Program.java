package main;

import java.util.ArrayList;

import entities.Cliente;
import entities.Loja;

public class Program extends Thread {

	public static void main(String[] args) {
		Loja loja1 = new Loja();
		Loja loja2 = new Loja();
		
		ArrayList<Loja> lojas = new ArrayList<>();
		
		lojas.add(loja1);
		lojas.add(loja2);
		
		Cliente cliente1 = new Cliente("victor",lojas);
		Cliente cliente2 = new Cliente("mariana",lojas);
		Cliente cliente3 = new Cliente("lara",lojas);
		Cliente cliente4 = new Cliente("caio",lojas);
		Cliente cliente5 = new Cliente("amanda",lojas);
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.printf("Saldo de um dos funcionários \nSalário: R$ %.2f\nInvestimento: R$ %.2f\n",
				loja1.getFuncionarios().get(0).getSalario().getSaldo(),
				loja1.getFuncionarios().get(0).getInvestimento().getSaldo());
		System.out.printf("Saldo de um dos funcionários \nSalário: R$ %.2f\nInvestimento: R$ %.2f\n",
				loja2.getFuncionarios().get(0).getSalario().getSaldo(),
				loja2.getFuncionarios().get(0).getInvestimento().getSaldo());
		System.out.printf("Saldo da loja 1: R$ %.2f\n",
				loja1.getConta().getSaldo());
		System.out.printf("Saldo da loja 2: R$ %.2f\n",
				loja2.getConta().getSaldo());
	}
}
