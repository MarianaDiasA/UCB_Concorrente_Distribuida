package entities;

public class ContaCPF implements Conta {
	
	private float saldo;
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double valor) {
		this.saldo += valor;
	}

}
