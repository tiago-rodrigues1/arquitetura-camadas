package br.edu.ifrn.pds.pratica.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.pds.pratica.negocio.dominio.Conta;

public class ContaDAO implements IRepositorioConta {

    @Override
    public boolean inserirConta(Conta conta) {

        boolean resultado = false;
        String query = "INSERT INTO conta(agencia, numero, titular, saldo) VALUES(?,?,?,?);";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, conta.getAgencia());
            comando.setString(2, conta.getNumero());
            comando.setString(3, conta.getTitular());
            comando.setDouble(4, conta.getSaldo());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

    @Override
    public boolean alterarConta(Conta conta) {

        boolean resultado = false;
        String query = "UPDATE conta set agencia = ?, titular = ?, saldo = ? where numero = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, conta.getAgencia());
            comando.setString(2, conta.getTitular());
            comando.setDouble(3, conta.getSaldo());
            comando.setString(4, conta.getNumero());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

    @Override
    public boolean removerConta(String numero) {
        boolean resultado = false;
        String query = "DELETE from conta where numero = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, numero);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

    @Override
    public Conta buscarConta(String numero) {

        Conta c1 = null;

        String query = "SELECT agencia, numero, titular, saldo from conta where numero = ?;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, numero);

            ResultSet resultSet = comando.executeQuery();

            if (resultSet.next()) {

                c1 = new Conta();
                c1.setAgencia(resultSet.getString("agencia"));
                c1.setNumero(resultSet.getString("numero"));
                c1.setTitular(resultSet.getString("titular"));
                c1.setSaldo(resultSet.getDouble("saldo"));
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return c1;
    }

    @Override
    public boolean verificarExistencia(String numero) {

        return buscarConta(numero) != null;
    }

    @Override
    public List<Conta> buscarTodos() {
        
        System.out.println("Cheguei");
        List<Conta> contas = new ArrayList<Conta>();

        String query = "SELECT agencia, numero, titular, saldo from conta;";

        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement comando = conexao.prepareStatement(query);

            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {

                Conta c1 = new Conta();
                c1.setAgencia(resultSet.getString("agencia"));
                c1.setNumero(resultSet.getString("numero"));
                c1.setTitular(resultSet.getString("titular"));
                c1.setSaldo(resultSet.getDouble("saldo"));
                contas.add(c1);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return contas;
    }

}
