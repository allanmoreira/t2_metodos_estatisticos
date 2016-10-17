package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by allanmoreira on 08/07/16.
 */
public class Calculo {

    private BigDecimal resultado;
    private final int CASAS_DECIMAIS = 4;

    public BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.add(valor2);
        resultado = resultado.setScale(CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
        return resultado;
    }

    public BigDecimal somaArrendondaPraCima(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.add(valor2);
        resultado = resultado.setScale(CASAS_DECIMAIS, RoundingMode.UP);
        return resultado;
    }

    public BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.subtract(valor2);
        resultado = resultado.setScale(CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
        return resultado;
    }

    public BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.multiply(valor2);
        resultado = resultado.setScale(CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
        return resultado;
    }

    public BigDecimal multiplicaArredondaPraCima(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.multiply(valor2);
        resultado = resultado.setScale(CASAS_DECIMAIS, RoundingMode.UP);
        return resultado;
    }

    public BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.divide(valor2, CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
        return resultado;
    }

    public BigDecimal divideArredondaPraCima(BigDecimal valor1, BigDecimal valor2) {
        resultado = valor1.divide(valor2, CASAS_DECIMAIS, RoundingMode.UP);
        return resultado;
    }
}

