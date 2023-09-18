package br.edu.ifrn.pds.pratica.negocio;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public class FachadaConta implements IFachada {

    private ControladorConta controlador;

    public FachadaConta() {
        this.controlador = new ControladorConta();
    }

    @Override
    public boolean inserirConta(Conta conta) {
        return this.controlador.inserirConta(conta);

    }

    @Override
    public boolean alterarConta(Conta conta) {
        return this.controlador.alterarConta(conta);
    }

    @Override
    public boolean removerConta(String numero) {
        return this.controlador.removerConta(numero);
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
