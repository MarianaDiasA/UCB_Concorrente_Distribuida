package entities;

import java.util.ArrayList;

public class ContaCNPJ implements Conta {
	
	private final float SALARIO = 2800;
	private float saldo;
	private ArrayList<Funcionario> funcionarios;
	private Banco banco = new Banco();
	
	
	public ContaCNPJ(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double valor) {
		this.saldo += valor;
		this.possuiValor();
	}
	
	private void pagarFuncionarios() {
		float salarioIndividual = SALARIO / this.getFuncionarios().size();
		
		for (Funcionario funcionario : funcionarios) {
			banco.fazerSaque(this, salarioIndividual);
			funcionario.receberSalario(salarioIndividual);
		}
	}
	
	public void possuiValor() {
		if (this.getSaldo() >= SALARIO) {
			this.pagarFuncionarios();
		}
	}
}
