package entities;

public class Funcionario {
	private Conta contaInvestimento;
	private Conta contaSalario;
	private Banco banco;
	
	public Funcionario() {
		contaInvestimento = new ContaCPF();
		contaSalario = new ContaCPF();
		banco = new Banco();
	}
	
	public Conta getInvestimento() {
		return contaInvestimento;
	}

	public Conta getSalario() {
		return contaSalario;
	}
	
	public void receberSalario(double valor) {
		banco.fazerDeposito(this.getInvestimento(), valor*0.2);
		banco.fazerDeposito(this.getSalario(), valor*0.8);
	}
	
	@Override
	public String toString() {
		return String.format("Funcionário: \nSalário: %.2f \nInvestimento: %.2f \n", 
				this.getSalario().getSaldo(), this.getInvestimento().getSaldo());
	}
}

