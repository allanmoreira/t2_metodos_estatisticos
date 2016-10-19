package util;

import logica.Frequencia;

import java.util.ArrayList;

/**
 * Created by allanmoreira on 17/10/16.
 */
public class Ordenacao {
    public static void bubbleSortOtimizado(ArrayList<Frequencia> v){
        boolean ordenado = false;

        while(ordenado == false) {
            ordenado = true;
            for (int i = 0; i < v.size()-1; i++) {
                if(v.get(i).getXi() > v.get(i+1).getXi()){
                    troca(v, i, i+1);
                    ordenado = false;
                }
            }
        }
    }

    private static void troca(ArrayList<Frequencia> v, int i, int j) {
        Frequencia f = v.get(i);
        v.set(i, v.get(j));
        v.set(j, f);
    }
}
