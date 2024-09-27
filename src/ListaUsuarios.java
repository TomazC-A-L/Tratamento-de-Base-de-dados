/*
 * Implementação de lista simplesmente encadeada para guardar os usuários.
 */
package src;
public class ListaUsuarios {
    
    public Usuario primeiro;
    private boolean jaInserido;

    public ListaUsuarios() {
        this.primeiro = null;
        this.jaInserido = false;
    }

    public void insereNaLista(Usuario usuario){
        jaInserido = false;
        if(vazia()){
            primeiro = usuario;
        }else{
            Usuario aux = primeiro;
            while(aux.prox != null){
                if((usuario.getId()).equals(aux.getId())){
                    jaInserido = true;
                    if(!((aux.getLingua()).equals(usuario.getLingua()))){
                        aux.setQuantidadeLinguas(1);
                    }
                }
                aux = aux.prox;
            }
            if((usuario.getId()).equals(aux.getId())){
                jaInserido = true;
                if(!((aux.getLingua()).equals(usuario.getLingua()))){
                    aux.setQuantidadeLinguas(1);
                }
            }
            if(!jaInserido){
                aux.prox = usuario;
            }
        }
    }

    public boolean vazia(){
        return (primeiro == null);
    }

    public Usuario getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Usuario primeiro) {
        this.primeiro = primeiro;
    }

    public boolean isJaInserido() {
        return jaInserido;
    }

    public void setJaInserido(boolean jaInserido) {
        this.jaInserido = jaInserido;
    }

}