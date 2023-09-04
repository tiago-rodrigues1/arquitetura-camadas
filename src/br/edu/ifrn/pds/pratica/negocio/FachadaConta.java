package br.edu.ifrn.pds.pratica.negocio;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public class FachadaConta implements IFachada {

	private ControladorConta controlador;
	
	public FachadaConta() {
		this.controlador = new ControladorConta();
	}
	
	@Override
	public void inserirConta(Conta conta) {
		this.controlador.inserirConta(conta);
		
	}
	@Override
	public void alterarConta(Conta conta) {
		this.controlador.alterarConta(conta);
	}

	@Override
	public void removerConta(String numero) {
		this.controlador.removerConta(numero);
	}

	@Override
	public Conta buscarConta(String numero) {
		return this.controlador.buscarConta(numero);
	}

	@Override
	public List<Conta> buscarTodos() {
		return this.controlador.buscarTodos();
	}

}
