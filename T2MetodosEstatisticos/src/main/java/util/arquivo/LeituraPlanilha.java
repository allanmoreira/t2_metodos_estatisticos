package util.arquivo;

import logica.Dados;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by allanmoreira on 15/10/16.
 */

public class LeituraPlanilha {

    public ArrayList<Dados> lerPlanilha() throws UnsupportedEncodingException {
        int linha = 1;
        int colunaIdade = 1;
        int colunaCandidato = 2;
        int cont = 1;
        ArrayList<Dados> listaDados = new ArrayList<Dados>(5000);

        String caminhoPlanilha;
        caminhoPlanilha = new CaminhoDados().caminhoPlanilhaDados();

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(caminhoPlanilha));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(1);

            while (linha < 5001) {
                try {
                    Row row = hssfSheet.getRow(linha);
                    Cell celulaIdade = row.getCell(colunaIdade);
                    Cell celulaCandidato = row.getCell(colunaCandidato);

                    Dados dados = new Dados((int) celulaIdade.getNumericCellValue(),
                            cont,
                            celulaCandidato.getStringCellValue());
                    listaDados.add(dados);
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException - Linha: " + linha);
                }
                linha++;
                cont++;
            }

            fileInputStream.close();
            FileOutputStream outFile = new FileOutputStream(new File(caminhoPlanilha));
            hssfWorkbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo [" + caminhoPlanilha + "] não encontrado!");
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler a planilha!");
        }
        return listaDados;
    }

}
