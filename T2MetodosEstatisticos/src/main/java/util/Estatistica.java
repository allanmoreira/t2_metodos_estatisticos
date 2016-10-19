package util;

import logica.Estimador;
import logica.Frequencia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by allanmoreira on 18/10/16.
 */
public class Estatistica {

    private static DecimalFormat formato = new DecimalFormat("#,##0.00");

    public double media(ArrayList<Integer> listaIdade){
        double soma = 0;
        for (Integer idade : listaIdade)
            soma+= idade;
        return arredonda(soma/listaIdade.size());
    }

    public ArrayList<Frequencia> tabelaFrequencia(ArrayList<Integer> lista){
        HashMap<Integer, Integer> tabela = new HashMap<Integer, Integer>();
        ArrayList<Frequencia> listaFreq = new ArrayList<Frequencia>();
        int cont = 1;
        for (int i = 0; i < lista.size(); i++) {
            int idade = lista.get(i);
            if(tabela.containsKey(idade))
                tabela.put(idade, tabela.get(idade) + 1);
            else
                tabela.put(idade, 1);
        }

        for (int s : tabela.keySet()) {
            int fi = tabela.get(s);
            Frequencia frequencia = new Frequencia(s, fi, cont++);
            listaFreq.add(frequencia);
        }

        return listaFreq;
    }

    public double variancia(ArrayList<Frequencia> lista, double media, double N){
        double resultado = 0;
        for (Frequencia f : lista)
            resultado = (resultado + (((Math.pow(f.getXi() - media,2))) * f.getFi()));

        resultado = resultado/(N-1);
        return arredonda(resultado);
    }

    public double desvioPadrao(double variancia){
        return arredonda(Math.sqrt(variancia));
    }

    public ArrayList<Estimador> comportamentoEstimadores(List<Set<Frequencia>> subConjutos, int nAmostras, double media) {
        ArrayList<Double> mediaDosCjtos = new ArrayList<>();
        ArrayList<Frequencia> listaFrequencias = new ArrayList<>();
        ArrayList<Integer> listaIdades;
        ArrayList<Estimador> listaEstimadores = new ArrayList<>();

        List<ArrayList<Double>> listaMediaCjtos = new ArrayList<>();
        List<ArrayList<Frequencia>> listaListaFrequencias = new ArrayList<>();

        double xBarra = 0;
        for (Set<Frequencia> conjuntoFrequencia: subConjutos) {

            listaIdades = new ArrayList<>(conjuntoFrequencia.size());

            for (Frequencia f : conjuntoFrequencia) {
                listaIdades.add(f.getXi());
                listaFrequencias.add(f);
            }
            xBarra = media(listaIdades);
            mediaDosCjtos.add(xBarra);
            listaMediaCjtos.add(mediaDosCjtos);
            listaListaFrequencias.add(listaFrequencias);
        }

//        double variancia = variancia(listaFrequencias, xbarra, N);
//        double desvioPadrao = desvioPadrao(variancia);

        for (int i = 0; i < mediaDosCjtos.size(); i++) {
            double pChapeu = pChapeu(media, nAmostras, listaMediaCjtos.get(i));
            Estimador estimador = new Estimador(xBarra, pChapeu, listaListaFrequencias.get(i));
            listaEstimadores.add(estimador);
        }
        return listaEstimadores;
    }

    public double pChapeu(double media, int nAmostras, ArrayList<Double> listaMedias) {
        double soma = 0;
        for (Double i : listaMedias) {
            soma+= Math.pow(i - media, 2);
        }

        return arredonda(Math.sqrt(soma/nAmostras));
    }

    public double pChapeuTeoria(double media, double desvioPadrao, double n, double N){
//        HashMap<Double, Double> xNormal = new HashMap<Double, Double>(1);

        double desvioPadraoXBarra = (desvioPadrao / Math.sqrt(2)) * Math.sqrt((N-n)/(N-1));

        return arredonda(desvioPadraoXBarra, 2);
//        return desvioPadraoXBarra;
    }

    public ArrayList<Frequencia> extraiAmostrasAleatorias(ArrayList<Frequencia> tabelaFrequencia) {
        ArrayList<Frequencia> numeros = tabelaFrequencia;
        ArrayList<Frequencia> listaResultado = new ArrayList<Frequencia>();
        //Embaralhamos os números:
        Collections.shuffle(numeros);
        //Mostramos 6 aleatórios
        for (int i = 0; i < 15; i++)
            listaResultado.add(numeros.get(i));

        return listaResultado;
    }

    private double arredonda(double valor){
        return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static double arredonda(double valor, int casasDecimais) {
        if (casasDecimais < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, casasDecimais);
        valor = valor * factor;
        long tmp = Math.round(valor);
        return (double) tmp / factor;
    }

    public List<Set<Frequencia>> subConjutos(List<Frequencia> conjunto, int tamanho, int qtdeAmostras) {
        List<Set<Frequencia>> listaSubConjuntos = new ArrayList<>();
        subConjutos(conjunto, tamanho, 0, new HashSet<Frequencia>(), listaSubConjuntos, qtdeAmostras);
        return listaSubConjuntos;
    }

    private void subConjutos(List<Frequencia> conjunto,
                             int tamanho, int indice,
                             Set<Frequencia> conjuntoAtual,
                             List<Set<Frequencia>> listaSubConjuntos, int qtdeAmostras) {
        if (listaSubConjuntos.size() == qtdeAmostras)
            return;

        // se o conjunto está cheio, retorna
        if (conjuntoAtual.size() == tamanho) {
            listaSubConjuntos.add(new HashSet<>(conjuntoAtual));
            return;
        }

        //unseccessful stop clause
        if (indice == conjunto.size())
            return;
        Frequencia x = conjunto.get(indice);
        conjuntoAtual.add(x);
        // "supondo" que x está no subconjunto
        subConjutos(conjunto, tamanho, indice+1, conjuntoAtual, listaSubConjuntos, qtdeAmostras);
        conjuntoAtual.remove(x);
        //"supondo" que x não está no subconjunto
        subConjutos(conjunto, tamanho, indice+1, conjuntoAtual, listaSubConjuntos, qtdeAmostras);
    }


}
