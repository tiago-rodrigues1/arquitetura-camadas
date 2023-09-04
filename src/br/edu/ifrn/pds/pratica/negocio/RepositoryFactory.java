package br.edu.ifrn.pds.pratica.negocio;

import br.edu.ifrn.pds.pratica.persistencia.ContaDAO;
import br.edu.ifrn.pds.pratica.persistencia.IRepositorioConta;
import br.edu.ifrn.pds.pratica.persistencia.RepositorioContas;

public class RepositoryFactory {

    public static IRepositorioConta fabricar(String tipoImpl) {

        if (tipoImpl.equalsIgnoreCase("memoria")) {
            //implementação para armazenar em memória
            return new RepositorioContas();
        } else {
            //implementação para armanezar no BD
            return new ContaDAO();
        }
    }
}
