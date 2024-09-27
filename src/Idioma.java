/*
 * Classe responsável por criar o objeto Idioma que guarda os dados importantes de cada arquivo.
 */
package src;
public class Idioma {
    private int tweetsVolume;
    private int positivos;
    private int negativos;
    private int neutros;
    private String name;
    public Idioma prox;
    public Idioma ante;


    public Idioma(String name, int positivos, int negativos, int neutros) {
        this.name = name;
        this.positivos = positivos;
        this.negativos = negativos;
        this.neutros = neutros;
        this.prox = null;
        this.ante = null;
        setTweetsVolume();
    }

    private void setTweetsVolume() {
        this.tweetsVolume = positivos + negativos + neutros;
    }

    public int getTweetsVolume() {
        return tweetsVolume;
    }

    public String getName() {
        return name;
    }

    public int getPositivos() {
        return positivos;
    }

    public int getNegativos() {
        return negativos;
    }

    public void setTweetsVolume(int tweetsVolume) {
        this.tweetsVolume = tweetsVolume;
    }

    public void setPositivos(int positivos) {
        this.positivos = positivos;
    }

    public void setNegativos(int negativos) {
        this.negativos = negativos;
    }

    public int getNeutros() {
        return neutros;
    }

    public void setNeutros(int neutros) {
        this.neutros = neutros;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Idioma getProx() {
        return prox;
    }

    public void setProx(Idioma prox) {
        this.prox = prox;
    }

    public Idioma getAnte() {
        return ante;
    }

    public void setAnte(Idioma ante) {
        this.ante = ante;
    }
    
}
