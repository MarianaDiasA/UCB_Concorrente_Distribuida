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

	}
}
