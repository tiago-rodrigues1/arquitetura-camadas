package br.edu.ifrn.pds.pratica.ui;


import br.edu.ifrn.pds.pratica.negocio.FachadaConta;
import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        FachadaConta fachadaConta = new FachadaConta();
        
        Conta conta = new Conta("0806", "12345-6", "Teste", 600.0);
        fachadaConta.inserirConta(conta);
        
        Conta conta2 = new Conta("0806", "12345789-6", "Teste2", 6000.0);
        fachadaConta.inserirConta(conta2);
        
        List<Conta> contas = fachadaConta.buscarTodos();

        for (Conta conta1 : contas) {
            System.out.println("Titular: " + conta1.getTitular());
        }

    }

}
