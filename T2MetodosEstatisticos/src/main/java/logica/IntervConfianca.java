package logica;

/**
 * Created by allanmoreira on 19/10/16.
 */
public class IntervConfianca {
    private double idadeDe, idadeAte;

    public IntervConfianca(double idadeDe, double idadeAte) {

        this.idadeDe = idadeDe;
        this.idadeAte = idadeAte;
    }

    public double getIdadeDe() {
        return idadeDe;
    }

    public void setIdadeDe(double idadeDe) {
        this.idadeDe = idadeDe;
    }

    public double getIdadeAte() {
        return idadeAte;
    }

    public void setIdadeAte(double idadeAte) {
        this.idadeAte = idadeAte;
    }

}
