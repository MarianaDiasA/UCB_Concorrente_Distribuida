package entities;

import java.util.ArrayList;

public class Loja {
	
	private Conta conta;
	ArrayList<Funcionario> funcionarios;
	
	public Loja() {
		funcionarios = new ArrayList<>();
		//contratando funcionários
		this.contrataFuncionario(new Banco());
		this.contrataFuncionario(new Banco());
		conta = new ContaCNPJ(this.getFuncionarios(),new Banco());
	}
	
	public Loja(Banco banco) {
		funcionarios = new ArrayList<>();
		//contratando funcionários
		this.contrataFuncionario(banco);
		this.contrataFuncionario(banco);
		conta = new ContaCNPJ(this.getFuncionarios(), banco);
	}
	
	private void contrataFuncionario(Banco banco) {
		funcionarios.add(new Funcionario(banco));
	}
	
	public Conta getConta() {
		return conta;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
