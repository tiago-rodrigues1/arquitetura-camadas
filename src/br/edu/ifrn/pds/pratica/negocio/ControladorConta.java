package br.edu.ifrn.pds.pratica.negocio;

import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;
import br.edu.ifrn.pds.pratica.persistencia.ContaDAO;
import br.edu.ifrn.pds.pratica.persistencia.IRepositorioConta;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ControladorConta {

    private IRepositorioConta repContas;

    public ControladorConta() {
        
        Properties properties = new Properties();
        try {
            
            FileReader reader = new FileReader("conf/implementacao.properties");
            properties.load(reader);
            String implementacao = properties.getProperty("impl");
            this.repContas = RepositoryFactory.fabricar(implementacao);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean inserirConta(Conta conta) {
        return this.repContas.inserirConta(conta);
    }
    public boolean removerConta(String numero) {
        return this.repContas.removerConta(numero);
    }
    public boolean alterarConta(Conta c) {
        return this.repContas.alterarConta(c);
    }
    public Conta buscarConta(String numero) {
        return this.repContas.buscarConta(numero);
    }
    public boolean verificarExistencia(String numero) {
        return this.repContas.verificarExistencia(numero);
    }
    public List<Conta> buscarTodos() {
        return this.repContas.buscarTodos();
    }
}
