/*
 * Implementação da estrutura de lista duplamente encadeada para guardar ordenadamente as células dos idiomas.
 */
package src;
public class ListaIdiomas{

    private Celula primeiro;
    private Celula fim;

    public ListaIdiomas() {
        this.primeiro = null;
        this.fim = null;
    }

    public void inserirNoInicio(Idioma idioma) {
        Celula cel = new Celula(idioma);
        if (primeiro == null) {
            primeiro = cel;
            fim = cel;
        } else {
            cel.prox = primeiro;
            primeiro.ante  = cel;
            primeiro = cel;
        }
    }

    public void inserirNoFinal(Idioma idioma) {
        Celula cel = new Celula(idioma);
        if (fim == null) {
            primeiro = cel;
            fim = cel;
        } else {
            fim.prox = cel;
            cel.ante = fim;
            fim = cel;
        }
    }

    public void insereNegativo(Idioma idioma) {
        Celula cel = new Celula(idioma);
        if (primeiro == null) {
            primeiro = cel;
            fim = cel;
        } else {
            Celula atual = primeiro;
            while (atual != null && atual.idioma.getNegativos() > idioma.getNegativos()) {
                atual = atual.prox;
            }
            if (atual == null) {
                inserirNoFinal(idioma);
            } else if (atual == primeiro) {
                inserirNoInicio(idioma);
            } else {
                Celula ante = atual.ante;
                ante.prox = cel;
                cel.ante = ante;
                cel.prox = atual;
                atual.ante = cel;
            }
        }
    }

    public void inserePositivo(Idioma idioma){
        Celula cel = new Celula(idioma);
        if (primeiro == null) {
            primeiro = cel;
            fim = cel;
        } else {
            Celula atual = primeiro;
            while (atual != null && atual.idioma.getPositivos() > idioma.getPositivos()) {
                atual = atual.prox;
            }
            if (atual == null) {
                inserirNoFinal(idioma);
            } else if (atual == primeiro) {
                inserirNoInicio(idioma);
            } else {
                Celula ante = atual.ante;
                ante.prox = cel;
                cel.ante = ante;
                cel.prox = atual;
                atual.ante = cel;
            }
        }
    }

    public void imprimirLista() {
        Celula atual = primeiro;
        System.out.println("Ranking dos paises com mais tweets positivos: ");
        while (atual != null) {
            System.out.println(atual.idioma.getName()+": \t"+atual.idioma.getPositivos());
            atual = atual.prox;
        }
        System.out.println();
    }

    public void imprimirListaNegativa() {
        Celula atual = primeiro;
        System.out.println("\nRanking dos paises com mais tweets negativos: ");
        while (atual != null) {
            System.out.println(atual.idioma.getName()+": \t"+atual.idioma.getNegativos());
            atual = atual.prox;
        }
        System.out.println();
    }
    
    public Celula getPrimeiro() {
        return primeiro;
    }
    
}