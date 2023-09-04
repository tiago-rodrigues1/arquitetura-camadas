package br.edu.ifrn.pds.pratica.negocio;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public interface IFachada {
	
	public void inserirConta(Conta conta) ;
	public void alterarConta(Conta conta);
	public void removerConta(String numero); 
	public Conta buscarConta(String numero);
	public List<Conta> buscarTodos();
}
