package entities;

public class Funcionario extends Thread{
	private ContaCPF contaInvestimento;
	private ContaCPF contaSalario;
	private float SALARIO = 1400;
	
	public Funcionario(Banco banco) {
		contaInvestimento = new ContaCPF(banco);
		contaSalario = new ContaCPF(banco);
	}
	
	public Conta getInvestimento() {
		return contaInvestimento;
	}

	public Conta getSalario() {
		return contaSalario;
	}
	
	public void receberSalario(double valor) {
		contaInvestimento.depositar((float) (valor*0.2));
		contaSalario.depositar((float) (valor*0.8));
	}
	
	@Override
	public String toString() {
		return String.format("Funcionário: \nSalário: %.2f \nInvestimento: %.2f \n", 
				this.getSalario().getSaldo(), this.getInvestimento().getSaldo());
	}
	
	@Override
	public void run() {
		this.receberSalario(SALARIO);
	}
}

