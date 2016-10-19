package logica;

import java.util.ArrayList;

/**
 * Created by allanmoreira on 19/10/16.
 */
public class Estimador {
    private double media, pChapeu;
    private ArrayList<Frequencia> listaFrequencias;

    public Estimador(double media, double pChapeu, ArrayList<Frequencia> listaFrequencias) {
        this.media = media;
        this.pChapeu = pChapeu;
        this.listaFrequencias = listaFrequencias;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getpChapeu() {
        return pChapeu;
    }

    public void setpChapeu(double pChapeu) {
        this.pChapeu = pChapeu;
    }

    public ArrayList<Frequencia> getListaFrequencias() {
        return listaFrequencias;
    }

    public void setListaFrequencias(ArrayList<Frequencia> listaFrequencias) {
        this.listaFrequencias = listaFrequencias;
    }
}
