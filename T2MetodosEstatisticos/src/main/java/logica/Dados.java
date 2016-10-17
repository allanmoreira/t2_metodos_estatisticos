package logica;

/**
 * Created by allanmoreira on 15/10/16.
 */
public class Dados {

    private int idade, id;
    private String candidato;

    public Dados(int idade, int id, String candidato) {
        this.idade = idade;
        this.id = id;
        this.candidato = candidato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }
}
