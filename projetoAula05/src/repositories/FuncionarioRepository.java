package repositories;

import entities.Funcionario;

public abstract class FuncionarioRepository {
	
	
	
	public abstract void exportar(Funcionario funcionario) throws Exception;

}
