/*
 * Classe responsável por ler e extrair as informações dos arquivos para uso posterior em outros métodos de outras classes.
 */
package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor{

    private int positivos;
    private int negativos;
    private int neutros;

    public Leitor() {
        this.positivos = 0;
        this.negativos = 0;
        this.neutros = 0;
    }

    public void leArquivo(String arquivo) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(arquivo));
        String linha;
        String lingua = arquivo.split("_")[0];
        Usuario usuario;
        ListaUsuarios auxLista = new ListaUsuarios();
        while((linha = bf.readLine()) != null){
            if(linha.split(",")[0].equals("TweetID")){
                continue;
            }
            analisaSentimento(linha.split(",")[1]);
            usuario = new Usuario(linha.split(",")[2], lingua);
            auxLista.insereNaLista(usuario);
        }
        bf.close();

        DataSet.setUsuarios(auxLista);

        Idioma idioma = new Idioma(lingua, positivos, negativos, neutros);
        DataSet.setIdiomasNegativos(idioma);
        DataSet.setIdiomaPositivo(idioma);

        positivos = 0;
        negativos = 0;
        neutros   = 0;

    }

    public void analisaSentimento(String sentimento){
        if (sentimento.equals("Positive")) {
            positivos++;
        } else if (sentimento.equals("Negative")) {
            negativos++;
        } else {
            neutros++;
        }
    }
}