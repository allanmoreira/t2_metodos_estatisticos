package util;

import logica.Dados;
import logica.Frequencia;
import org.junit.Before;
import org.junit.Test;
import util.arquivo.LeituraPlanilha;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by allanmoreira on 18/10/16.
 */
public class EstatisticaTest {
    private Estatistica estatistica;
    private ArrayList<Dados> listaDados;
    private ArrayList<Integer> listaIdadeCandA;
    private ArrayList<Integer> listaIdadeCandC;

    @Before
    public void setUp() throws Exception {
        estatistica = new Estatistica();
        listaDados = new LeituraPlanilha().lerPlanilha();
    }

    @Test
    public void testPChapeu() throws Exception {
        ArrayList<Double> listaDouble = new ArrayList<Double>(){{
            add(25.0);
            add(30.0);
            add(35.0);
            add(40.0);
            add(45.0);
            add(35.0);
            add(40.0);
            add(45.0);
            add(50.0);
            add(45.0);
            add(50.0);
            add(55.0);
            add(55.0);
            add(60.0);
            add(65.0);
        }};

        ArrayList<Integer> lista = new ArrayList<Integer>(){{
            add(25);
            add(30);
            add(35);
            add(40);
            add(45);
            add(35);
            add(40);
            add(45);
            add(50);
            add(45);
            add(50);
            add(55);
            add(55);
            add(60);
            add(65);
        }};

        double xbarra = estatistica.media(lista);
        double valor = estatistica.pChapeu(xbarra, 500, listaDouble);

        System.out.println("VALOR P-CHAPEU = " + valor);
    }

    @Test
    public void testPChapeuDouble() throws Exception {
//        Estatistica estatistica = new Estatistica();
//        System.out.println(estatistica.pChapeu(45, 17.078, 2, 6));
    }

    @Test
    public void testFatorial() throws Exception {
        System.out.println(fatorial_1(5000));
    }

    public static int fatorial_1(int n){
        if (n == 0){
            return 1;
        }
        int a = n * fatorial_1(n-1);
        return a;
    }

    @Test
    public void testSubConjuntos() throws Exception {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");
        lista.add("F");

        List<Set<String>> subsets = getSubsets(lista, 2,5);
        int cont = 1;
        for (Set<String> c : subsets) {
            Set<String> s = c;
//            System.out.println("Conjunto " + cont);
            for (String i : s) {
                System.out.print(i);
            }
            System.out.println();
        }

    }

    private static void getSubsets(List<String> superConjunto, int tamanho, int indice, Set<String> cjtoAtual, List<Set<String>> solution, int qtdeAmostras) {
        System.out.println("CJTO ATUAL: " + cjtoAtual.toString());
        if (solution.size() == qtdeAmostras)
            return;
        //successful stop clause
        if (cjtoAtual.size() == tamanho) {
            solution.add(new HashSet<>(cjtoAtual));
            return;
        }
        //unseccessful stop clause
        if (indice == superConjunto.size())
            return;
        String x = superConjunto.get(indice);
        cjtoAtual.add(x);
        //"guess" x is in the subset
        getSubsets(superConjunto, tamanho, indice+1, cjtoAtual, solution, qtdeAmostras);
        cjtoAtual.remove(x);
        //"guess" x is not in the subset
        getSubsets(superConjunto, tamanho, indice+1, cjtoAtual, solution, qtdeAmostras);
    }

    public static List<Set<String>> getSubsets(List<String> superSet, int tamanho, int qtdeAmostras) {
        List<Set<String>> res = new ArrayList<>();
        getSubsets(superSet, tamanho, 0, new HashSet<String>(), res, qtdeAmostras);
        return res;
    }
}