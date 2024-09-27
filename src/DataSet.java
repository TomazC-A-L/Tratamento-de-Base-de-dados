/*
 * Classe responsável por armazenar todas as listas de usuário e idioma para processamento de dados.
 */
package src;
import java.io.IOException;

public class DataSet {
    
    private static final String[] CAMINHOS = {"Albanian_Twitter_sentiment.csv", "Bosnian_Twitter_sentiment.csv", "Bulgarian_Twitter_sentiment.csv",
    "Croatian_Twitter_sentiment.csv", "English_Twitter_sentiment.csv", "German_Twitter_sentiment.csv", 
    "Hungarian_Twitter_sentiment.csv", "Polish_Twitter_sentiment.csv", "Portuguese_Twitter_sentiment.csv",
    "Russian_Twitter_sentiment.csv", "Serbian_Twitter_sentiment.csv", "Slovak_Twitter_sentiment.csv", 
    "Slovenian_Twitter_sentiment.csv", "Spanish_Twitter_sentiment.csv", "Swedish_Twitter_sentiment.csv"};

    private static ListaUsuarios listaUsuarios;
    private static ListaIdiomas listaIdiomasPositivos;
    private static ListaIdiomas listaIdiomasNegativos;

    public DataSet() {
        DataSet.listaUsuarios = new ListaUsuarios();
        DataSet.listaIdiomasNegativos = new ListaIdiomas();
        DataSet.listaIdiomasPositivos = new ListaIdiomas();
    }

    public void guardarDados() throws IOException{
        Leitor leitor = new Leitor();
        for (int i = 0; i < CAMINHOS.length; i++) {
            leitor.leArquivo(CAMINHOS[i]);
        }
    }

    //Método responsável pela resposta da questão 1.
    public void volumeDeTweetsPorIdioma(ListaIdiomas lista){
        Celula aux = lista.getPrimeiro();
        while (aux.prox != null) {
            System.out.println("O volume total de tweets para a língua " + aux.idioma.getName() + " é:\t" + aux.idioma.getTweetsVolume() + ".");
            aux = aux.prox;
        }
        System.out.println("O volume total de tweets para a língua " + aux.idioma.getName() + " é:\t" + aux.idioma.getTweetsVolume() + ".");
    }

    //Método responsável pela resposta da questão 2.
    public void volumeDeTweetsPorSentimento(ListaIdiomas lista){
        Celula aux = lista.getPrimeiro();
        int positivos = 0;
        int negativos = 0;
        while (aux.prox != null) {
            positivos += aux.idioma.getPositivos();
            negativos += aux.idioma.getNegativos();
            aux = aux.prox;
        }
        positivos += aux.idioma.getPositivos();
        negativos += aux.idioma.getNegativos();
        System.out.println("O volume total de tweets positivos é: " + positivos + ".");
        System.out.println("O volume total de tweets negativos é: " + negativos + ".");
    }

    //Métodos responsáveis pela resposta da questão 3.
    public static void maiorSentimento(ListaIdiomas lista){
        Celula aux = lista.getPrimeiro();
        String idiomaNegativo = aux.idioma.getName();
        int quantidadeNegativo = aux.idioma.getNegativos();
        String idiomaPositivo = aux.idioma.getName();
        int quantidadePositivo = aux.idioma.getPositivos();
        while(aux.prox != null){
            if(aux.idioma.getPositivos() > quantidadePositivo){
                quantidadePositivo = aux.idioma.getPositivos();
                idiomaPositivo = aux.idioma.getName();
            }
            if (aux.idioma.getNegativos() > quantidadeNegativo){
                quantidadeNegativo = aux.idioma.getNegativos();
                idiomaNegativo = aux.idioma.getName();
            }
            aux = aux.prox;
        }
        if(aux.idioma.getPositivos() > quantidadePositivo){
            quantidadePositivo = aux.idioma.getPositivos();
            idiomaPositivo = aux.idioma.getName();
        }
        if (aux.idioma.getNegativos() > quantidadeNegativo){
            quantidadeNegativo = aux.idioma.getNegativos();
            idiomaNegativo = aux.idioma.getName();
        }
        System.out.println("O idioma com mais tweets negativos é: " + idiomaNegativo + ".");
        System.out.println("O idioma com mais tweets positivos é: " + idiomaPositivo + ".");

    }

    public void rankingSentimentos(){
        listaIdiomasNegativos.imprimirListaNegativa();
        listaIdiomasPositivos.imprimirLista();
    }

    //Método responsável pela resposta da questão 4.
    public void tweetsInternacionais(ListaUsuarios usuarios){
        Usuario aux = usuarios.primeiro;
        while(aux.prox != null){
            if(aux.getQuantidadeLinguas() > 1){
                System.out.println("O usuário de ID \"" + aux.getId() + "\" da lingua original \"" + aux.getLingua() + "\" tweetou em " + aux.getQuantidadeLinguas() + " linguas.");
            }
            aux = aux.prox;
        }
    }

    public static void setUsuarios(ListaUsuarios usuarios) {
        Usuario aux = usuarios.primeiro;
        while(aux.prox != null) {
            listaUsuarios.insereNaLista(aux);
            aux = aux.prox;
        }
        listaUsuarios.insereNaLista(aux);
    }

    public static void setIdiomasNegativos(Idioma idiomas) {
        listaIdiomasNegativos.insereNegativo(idiomas);
    }

    public static void setIdiomaPositivo(Idioma idiomas) {
        listaIdiomasPositivos.inserePositivo(idiomas);
    }

    public static ListaIdiomas getListaIdiomaNegativa() {
        return listaIdiomasNegativos;
    }

    public static ListaIdiomas getListaIdiomasPositiva() {
        return listaIdiomasPositivos;
    }

    public static ListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }
    
    public static String[] getCaminhos() {
        return CAMINHOS;
    }
}