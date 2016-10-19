package logica;

/**
 * Created by allanmoreira on 17/10/16.
 */
public class Frequencia {
    private int xi, fi, indice;

    public Frequencia(int xi, int fi, int indice) {
        this.xi = xi;
        this.fi = fi;
        this.indice = indice;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getFi() {
        return fi;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
