package entities;

public class Banco {

	public void fazerTransferencia(Conta contaPagante, Conta contaRecebedora, int valor) {
		contaPagante.setSaldo(-valor);
		contaRecebedora.setSaldo(valor);
	}
	
	public void fazerDeposito(Conta conta, double valor) {
		conta.setSaldo(valor);
	}
	
	public void fazerSaque(Conta conta, double valor) {
		conta.setSaldo(-valor);
	}
}
