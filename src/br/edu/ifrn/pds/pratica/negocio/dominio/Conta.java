package br.edu.ifrn.pds.pratica.negocio.dominio;

public class Conta {

    private String agencia;
    private String numero;
    private String titular;
    private double saldo;

    public Conta() {

    }

    public Conta(String agencia, String numero, String titular, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj instanceof Conta) {

            Conta outra = (Conta) obj;

            return this.numero.equals(outra.getNumero());
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conta{");
        sb.append("agencia=").append(agencia);
        sb.append(", numero=").append(numero);
        sb.append(", titular=").append(titular);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
