package entities;

import java.util.ArrayList;

public class Loja {
	
	private Conta conta;
	private Banco banco;
	private float SALARIO = 2800;
	ArrayList<Funcionario> funcionarios;
	
	public Loja() {
		conta = new Conta();
		banco = new Banco();
		funcionarios = new ArrayList<>();
		//contratando funcionários
		this.contrataFuncionario();
		this.contrataFuncionario();
	}
	
	private void contrataFuncionario() {
		funcionarios.add(new Funcionario());
	}
	
	private void pagarFuncionarios() {
		float salarioIndividual = SALARIO / this.getFuncionarios().size();
		
		for (Funcionario funcionario : funcionarios) {
			banco.fazerSaque(this.getConta(), salarioIndividual);
			funcionario.receberSalario(salarioIndividual);
		}
	}
	
	public void possuiValor() {
		if (this.getConta().getSaldo() == SALARIO)
			this.pagarFuncionarios();
	}
	
	public void testPagamento() {
		this.possuiValor();
	}

	public Conta getConta() {
		return conta;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
