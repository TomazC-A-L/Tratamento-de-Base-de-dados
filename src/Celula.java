/*
 * Classe responsável pela criação do objeto que é o elemento da lista, sendo este objeto, quem controla a lista.
 */

package src;

public class Celula {
    Idioma idioma;
    Celula ante;
    Celula prox;

    public Celula(Idioma idioma) {
        this.idioma = idioma;
        this.ante = null;
        this.prox = null;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Celula getAnte() {
        return ante;
    }

    public void setAnte(Celula ante) {
        this.ante = ante;
    }

    public Celula getProx() {
        return prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }
    
}
