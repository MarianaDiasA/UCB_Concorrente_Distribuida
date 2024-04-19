package entities;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	
	private final Lock lock = new ReentrantLock();

	public void fazerTransferencia(Conta contaPagante, Conta contaRecebedora, int valor) {
		lock.lock();
		System.out.println("Transferência feita!");
		contaPagante.setSaldo(-valor);
		contaRecebedora.setSaldo(valor);
		lock.unlock();
	}
	
	public void fazerDeposito(Conta conta, double valor) {
		lock.lock();
		System.out.println("Depósito feito!");
		conta.setSaldo(valor);
		lock.unlock();
	}
	
	public void fazerSaque(Conta conta, double valor) {
		lock.lock();
		System.out.println("Saque feito!");
		conta.setSaldo(-valor);
		lock.unlock();
	}
}
