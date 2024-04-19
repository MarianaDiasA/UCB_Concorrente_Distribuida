package entities;

import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Thread{
	private Conta conta;
	private Banco banco;
	private ArrayList<Loja> lojas;
	private String nome = "anônimo";
	
	public Cliente() {
		conta = new ContaCPF();
		banco = new Banco();
		banco.fazerDeposito(this.getConta(), 1000);
	}
	
	public Cliente(ArrayList<Loja> lojas) {
		conta = new ContaCPF();
		banco = new Banco();
		banco.fazerDeposito(this.getConta(), 1000);
		this.setLojas(lojas);
	}
	
	public Cliente(String nome,ArrayList<Loja> lojas) {
		conta = new ContaCPF();
		banco = new Banco();
		banco.fazerDeposito(this.getConta(), 1000);
		this.setNome(nome);
		this.setLojas(lojas);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}
	
	public ArrayList<Loja> getLojas() {
		return lojas;
	}
	
	public void setLojas(ArrayList<Loja> lojas) {
		this.lojas = lojas;
	}
	
	public void fazerCompra(Loja loja, double valor) {
		banco.fazerTransferencia(conta, loja.getConta(),(int) valor);
		System.out.printf("feito transferência de %s para loja no valor de R$ %.2f\n", this.getNome(), valor);
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
	
	public void run() {
		this.fazerCompras();
	}
	
}
