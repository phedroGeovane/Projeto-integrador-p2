public class Conta {
    private double saldo;
    private String nome;
    private String numConta;
    private String agencia;
    private double chequeEspecial;
    private Transferencia tansferencias;

    public Conta(String nome){
        this.nome = nome;
        this.numConta = ((int) (10000000 + Math.random() * 89999999)) + "-5";
        this.saldo = 0;
        this.agencia = "0002";
        this.chequeEspecial = 50000;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNumConta() {
        return this.numConta;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        if(valor > this.saldo){
            System.out.println("Não é possível sacar o valor: " +valor+ " pois o saldo atual é: " +this.saldo);
            return;
        }
        this.saldo -= valor;
    }

}
