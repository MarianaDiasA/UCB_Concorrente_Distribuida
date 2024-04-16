package entities;

public class Cliente {
	private Conta conta;
	private Banco banco;
	
	public Cliente() {
		conta = new Conta();
		conta.setSaldo(1000);
	}

	public float getSaldo() {
		return conta.getSaldo();
	}

	public void setBanco(Banco banco) {
		this.banco = banco; 
	}

	public void fazerCompra(Loja loja, int valor) {
		banco.fazerTransferencia(conta, loja.getConta(), valor);
	}
	
}
