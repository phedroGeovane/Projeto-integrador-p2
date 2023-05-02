import java.util.Scanner;

public class App {

    public static void clearTerminal(){
        int spaces = 10 * 1024;
        for(int i = 0; i < spaces; ++i){
            System.out.println(" ");
        }
    }

    public static void banner(){
        clearTerminal();
        System.out.println("---------- C4 BANK ----------\n");
    }

    public static void main(String[] args) {
        banner();
        System.out.println("\t\t[1] Login");
        System.out.println("\t\t[2] Criar conta");
        System.out.println("\t\t[3] Cartão de credito");
        System.out.println("\t\t[4] Pagamento");
        System.out.println("\t\t[5] Transferencia");
        System.out.println("\t\t[0] Sair\n");
        System.out.print("Escolha uma opção (0-5): ");

        Scanner input = new Scanner(System.in);
        int op = input.nextInt();

        switch(op) {
            case 0:
                System.exit(0);
            case 1:
                banner();
                System.out.print("\tDigite o usuario: ");
                String usuario = input.next();
                System.out.print("\tDigite a senha: ");
                String senha = input.next();

                Autenticacao autenticacao = new Autenticacao();

                boolean loginExiste = autenticacao.login(usuario,senha);
                if(loginExiste){
                    System.out.println("Bem vindo de volta: " + usuario);
                    break;
                }
                else {
                    System.out.println("Login incorreto ou conta inexistente");
                    System.exit(1);
                }
            case 2:
                banner();
                System.out.print("\tDigite seu nome: ");
                String nome = input.next();

                Conta contaBancaria = new Conta(nome);
                while(true){
                    banner();
                    System.out.println("\tDados da conta: ");
                    System.out.println("\tNome do titular: " + contaBancaria.getNome());
                    System.out.println("\tConta: " + contaBancaria.getNumConta() + " Agencia: " + contaBancaria.getAgencia());
                    System.out.println("\tCheque especial: " + contaBancaria.getChequeEspecial());
                    System.out.println("\tSaldo: " + contaBancaria.getSaldo());

                    System.out.println("\t[1] Sacar [2] Depositar [0] Sair");
                    System.out.print("\tEsolha uma opção: ");
                    int acao = input.nextInt();
                    if(acao == 1){
                        System.out.print("\tDigite o valor que deseja sacar: ");
                        double v = input.nextDouble();
                        contaBancaria.sacar(v);
                        System.out.println("\tO valor "+ v + " foi sacado com sucesso");
                        System.out.print("Pressione ENTER para continuar...");
                        input.next();
                    } else if (acao == 2) {
                        System.out.print("\tDigite o valor que deseja depositar: ");
                        double v = input.nextDouble();
                        contaBancaria.depositar(v);
                        System.out.println("\tO valor "+ v + " foi depositado com sucesso");
                        System.out.print("Pressione ENTER para continuar...");
                        input.next();
                    }
                    else System.exit(0);

                }
            case 3:
                banner();
                CartaoCredito cc = new CartaoCredito();
                System.out.println("\tDados do cartão: ");
                System.out.println("\tLimite total: " + cc.getLimiteCredito());
                System.out.println("\tSaldo disponivel: " + cc.getSaldoAtual());
                System.out.println("\tFatura: " + cc.getFatura());
                System.out.println("\tVencimento: " + cc.getVencimento());
                System.out.println("\tStatus: " + cc.getStatus());

                System.out.println("\t[1] Pagar fatura [2] Ajuste de limite [3] Bloquear [0] Sair");
                System.out.print("\tEsolha uma opção: ");
                int acao = input.nextInt();
                if(acao == 1){
                    System.out.print("\tDigite o valor que deseja pagar: ");
                    double v = input.nextDouble();
                    cc.pagamento(v);
                    System.out.println("\tPagamento realizado com sucesso");
                }else if(acao == 2){
                    System.out.print("\tInforme o novo limite: ");
                    double l = input.nextDouble();
                    cc.ajusteLimite(l);
                    System.out.println("\tLimite ajustado com sucesso");
                }else if(acao == 3){
                    cc.bloquearCartao();
                    System.out.println("\tCartão bloqueado.");
                }else if(acao == 0) System.exit(0);
                break;
            case 4:
                banner();
                System.out.print("\tDigite o tipo de pagamento: ");
                String t = input.next();
                System.out.print("\tDigite o valor: ");
                double v = input.nextDouble();

                Pagamento pg = new Pagamento();
                pg.pagar(t,v);
                break;
            case 5:
                banner();
                System.out.print("\tDigite a conta: ");
                String c = input.next();
                System.out.print("\tDigite o valor: ");
                double valor = input.nextDouble();

                Transferencia tf = new Transferencia();
                tf.transferir(c, valor);
                break;
        }
    }
}
