package util;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by allanmoreira on 17/10/16.
 */
public class CalculoTest {
    @Test
    public void testRaiz() throws Exception {
        Calculo calculo = new Calculo();
        System.out.println(calculo.raiz(new BigDecimal(16), 2));
    }
}