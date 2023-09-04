package br.edu.ifrn.pds.pratica.persistencia;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public interface IRepositorioConta {

	public boolean inserirConta(Conta conta); 
	public boolean alterarConta(Conta conta); 
	public boolean removerConta(String numero); 
	public Conta buscarConta(String numero); 
	public boolean verificarExistencia(String numero);
	public List<Conta> buscarTodos();
}