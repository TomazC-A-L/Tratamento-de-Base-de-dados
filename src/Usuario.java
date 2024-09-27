/*
 * Classe responsável por criar o objeto Usuário que guarda os dados importantes de cada usuário.
 */
package src;
public class Usuario {
   
    private String id;
    private String lingua;
    private int quantidadeLinguas;
    public Usuario prox;

    public Usuario(String id,String lingua){
        this.id   = id;
        this.lingua = lingua;
        this.quantidadeLinguas = 1;
        this.prox = null;
    }

    public String getId() {
        return id;
    }

    public String getLingua() {
        return lingua;
    }

    public Usuario getProx() {
        return prox;
    }

    public void setQuantidadeLinguas(int quantidadeLinguas) {
        this.quantidadeLinguas += quantidadeLinguas;
    }

    public int getQuantidadeLinguas() {
        return quantidadeLinguas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public void setProx(Usuario prox) {
        this.prox = prox;
    }

}
