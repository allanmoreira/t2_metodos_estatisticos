package logica;

import java.util.ArrayList;

/**
 * Created by allanmoreira on 19/10/16.
 */
public class Amostra {
    private double media;
    private ArrayList<Frequencia> listaFrequencias;
    private IntervConfianca intervConfianca;

    public Amostra(double media, ArrayList<Frequencia> listaFrequencias) {
        this.media = media;
        this.listaFrequencias = listaFrequencias;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public ArrayList<Frequencia> getListaFrequencias() {
        return listaFrequencias;
    }

    public void setListaFrequencias(ArrayList<Frequencia> listaFrequencias) {
        this.listaFrequencias = listaFrequencias;
    }

    public IntervConfianca getIntervConfianca() {
        return intervConfianca;
    }

    public void setIntervConfianca(IntervConfianca intervConfianca) {
        this.intervConfianca = intervConfianca;
    }
}
