package entities;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	
	private final Lock lock = new ReentrantLock();

	public void fazerTransferencia(Conta contaPagante, Conta contaRecebedora, int valor) {
		lock.lock();
		contaPagante.setSaldo(-valor);
		contaRecebedora.setSaldo(valor);
		lock.unlock();
	}
	
	public void fazerDeposito(Conta conta, double valor) {
		lock.lock();
		conta.setSaldo(valor);
		lock.unlock();
	}
	
	public void fazerSaque(Conta conta, double valor) {
		lock.lock();
		conta.setSaldo(-valor);
		lock.unlock();
	}
}
