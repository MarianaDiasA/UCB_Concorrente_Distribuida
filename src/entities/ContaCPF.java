package entities;

public class ContaCPF implements Conta {
	
	private float saldo;
	private Banco banco;
	
	public ContaCPF(Banco banco) {
		this.banco = banco;
	}
	
	public void depositar(float valor) {
		banco.fazerDeposito(this, valor);
	}
	
	public void transferir(Conta conta, int valor) {
		banco.fazerTransferencia(this, conta, valor);
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double valor) {
		this.saldo += valor;
	}

}
