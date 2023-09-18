package br.edu.ifrn.pds.pratica.negocio;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public interface IFachada {
	
	public boolean inserirConta(Conta conta) ;
	public boolean alterarConta(Conta conta);
	public boolean removerConta(String numero); 
	public Conta buscarConta(String numero);
	public List<Conta> buscarTodos();
}
