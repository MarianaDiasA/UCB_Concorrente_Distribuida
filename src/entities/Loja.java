package entities;

import java.util.ArrayList;

public class Loja {
	
	private Conta conta;
	ArrayList<Funcionario> funcionarios;
	
	public Loja() {
		funcionarios = new ArrayList<>();
		//contratando funcionários
		this.contrataFuncionario();
		this.contrataFuncionario();
		conta = new ContaCNPJ(this.getFuncionarios());
	}
	
	private void contrataFuncionario() {
		funcionarios.add(new Funcionario());
	}
	
	public Conta getConta() {
		return conta;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
