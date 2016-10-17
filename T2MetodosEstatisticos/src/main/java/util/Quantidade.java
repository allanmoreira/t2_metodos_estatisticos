package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Quantidade extends Calculo {

	private double valorEmDouble;
	private static DecimalFormat formato = new DecimalFormat("#,##0.00");

//	/**
//	 *
//	 * @param valorEmString
//	 * @return o resultado da conversão de uma String com padrão [#,##0.00] para o padrão de double em String
//	 */
//	public BigDecimal converteStringParaBigDecimal(String valorEmString) throws MoedaException {
//		return new BigDecimal(valorEmString.replaceAll("\\.", "").replaceAll("\\,", "."));
//	}



	// -----------------------------------------------------------------------------------------------------------------



	/*
	public static boolean isNegativo(BigDecimal valor){
		return valor.signum() == -1;
	}

	public double converteNumeroNegativo(String numero){
		if(numero.indexOf("-") != -1){
			return -getValorEmDoubleDe(numero);
		}
		return getValorEmDoubleDe(numero);
	}

	private double getValorEmDoubleDe(String valorEmString) {
		valorEmDouble = Double.parseDouble(valorEmString.replaceAll("\\.", "").replaceAll("\\,", "."));
		return valorEmDouble;
	}
	*/
	/*
	*//**
	 * @param valorEmDouble
	 * @return o valor em double formatado para o padrão [#.##0,00]
	 * @
	 *//*
	public String getValorEmStringDe(double valorEmDouble){
		return formato.format(valorEmDouble);
	}

	public BigDecimal converteStringParaBigDecimal(double valorEmDouble){
		return BigDecimal.valueOf(valorEmDouble);
	}

	public double getValorEmDoubleDe(BigDecimal valorEmBigDecimal) {
		return valorEmBigDecimal.doubleValue();
	}
	*/




	/*
	public int getValorEmIntDe(String valorEmString){
		try {
			valorEmInt = Integer.parseInt(valorEmString.replaceAll("\\.", "").replaceAll("\\,", "."));
		} catch (NumberFormatException e) {
    		System.out.println("Erro na classe Quantidade - Método getValorEmIntDe");
    		System.out.println(e.getMessage());
    	}
		return valorEmInt;
	}
	*/

}