package br.edu.ifrn.pds.pratica.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public class RepositorioContas implements IRepositorioConta {

    private ArrayList<Conta> contas;

    public RepositorioContas() {
        this.contas = new ArrayList<Conta>();
    }

    public boolean inserirConta(Conta conta) {
        if (this.verificarExistencia(conta.getNumero()) == false) {
            this.contas.add(conta);
            return true;
        }
        return false;
    }

    @Override
    public boolean alterarConta(Conta conta) {

        int posicao = this.contas.indexOf(conta);

        if (posicao != -1) {
            this.contas.set(posicao, conta);
            return true;
        }
        return false;
    }

    @Override
    public boolean removerConta(String numero) {
        Conta c = buscarConta(numero);

        if (c != null) {
            this.contas.remove(c);
            return true;
        }
        return false;
    }

    @Override
    public Conta buscarConta(String numero) {

        for (Conta conta : contas) {

            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }

        return null;
    }

    @Override
    public boolean verificarExistencia(String numero) {

        for (Conta conta : contas) {

            if (conta.getNumero().equals(numero)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Conta> buscarTodos() {
        return contas;
    }

}
