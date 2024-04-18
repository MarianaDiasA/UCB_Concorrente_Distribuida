package entities;

import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Thread{
	private Conta conta;
	private Banco banco;
	private ArrayList<Loja> lojas;
	
	public Cliente() {
		conta = new Conta();
		banco = new Banco();
		conta.setSaldo(1000);
	}

	public Conta getConta() {
		return conta;
	}

	public void fazerCompra(Loja loja, int valor) {
		banco.fazerTransferencia(conta, loja.getConta(), valor);
	}
	
	public ArrayList<Loja> getLojas() {
		return lojas;
	}
	
	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}

	public void fazerCompras() {
		int t = 1;
		while (this.getConta().getSaldo() > 0) {
			int numero = randomizarValor();
			numero = checkDinheiro(numero);
			
			if (t % 2 != 0) 
				this.fazerCompra(this.getLojas().get(0), numero);
			else 
				this.fazerCompra(this.getLojas().get(1), numero);
			t++;
		}
	}

	private int checkDinheiro(int numero) {
		if (this.getConta().getSaldo() < numero)
			numero = 100;
		return numero;
	}

	private int randomizarValor() {
		Random random = new Random();
		int numero;
		int escolha = random.nextInt(2);
		if (escolha == 0) 
			numero = 100;
		else 
			numero = 200;
		return numero;
	}
	
}
