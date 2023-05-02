public class Autenticacao {
    private String usuario = "admin";
    private String senha = "admin";

    public boolean login(String usr, String pwd){
        String l1 = usr +":"+ pwd;
        String l2 = this.usuario +":"+ this.senha;
        if(l1 == l2){
            return true;
        }
        else {
            return false;
        }
    }
}
