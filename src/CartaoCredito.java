public class CartaoCredito {
    private double limiteCredito;
    private double saldoAtual;
    private String vencimento;
    private double fatura;
    private String status;

    public CartaoCredito(){
        this.limiteCredito = 5000;
        this.saldoAtual = 2000;
        this.vencimento = "30/MÊS";
        this.fatura = 3000;
        this.status = "Ativo";
    }

    public double getLimiteCredito() {
        return this.limiteCredito;
    }

    public double getSaldoAtual() {
        return this.saldoAtual;
    }

    public String getVencimento() {
        return this.vencimento;
    }

    public double getFatura(){
        return this.fatura;
    }

    public String getStatus(){
        return this.status;
    }

    public void ajusteLimite(double novoLimite){
        if(novoLimite <= 0){
            System.out.println("Não foi possível ajustar o limite de credito para: " + novoLimite);
            return;
        }
        this.limiteCredito = novoLimite;
    }

    public void pagamento(double valor){
        this.fatura -= valor;
        this.saldoAtual += valor;
    }

    public void bloquearCartao(){
        this.status = "Bloqueado";
    }

}
