package util;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by allanmoreira on 16/10/16.
 */
public class Estatistica extends Calculo {

    public BigDecimal media(ArrayList<Integer> listaIdade){
        double soma = 0;
        Calculo calculo = new Calculo();
        for (Integer idade : listaIdade) {
            soma+= idade;
        }
        BigDecimal resultado = calculo.divide(new BigDecimal(soma), new BigDecimal(listaIdade.size()));
        return resultado;
    }

    public BigDecimal variancia(ArrayList<Integer> lista, BigDecimal media, BigDecimal N){
        //TODO: Continuar o calculo da variancia
        return null;
    }
}
