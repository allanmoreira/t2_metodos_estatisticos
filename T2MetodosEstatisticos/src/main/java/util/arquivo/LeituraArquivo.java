/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.arquivo;

/**
 *
 * @author Allan Moreira
 */
import logica.Dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraArquivo {

    public ArrayList<Dados> ler(String nomeArq) throws IOException {
        ArrayList<Dados> listaDados = new ArrayList<>();
        int id = 1;

        try {
            // Abre o arquivo
            FileReader f = new FileReader(nomeArq);
            BufferedReader buf = new BufferedReader(f);
            try {
                String line;
                String[] str;
                // Le as informacoes do arquivo (apenas uma linha por vez)
                while ((line = buf.readLine()) != null) {
                    // Opção 1: quebra a linha lida em string tendo como divisor o caracter definido por parametro
                    str = line.split(",");

                    // Caso a linha esteja vazia, não a adiciona ao array
//                    if(!"".equals(s))

                    int idade = Integer.parseInt(str[0]);
                    String cadidato = str[1];
                    Dados dados = new Dados(idade, id, cadidato);
                    listaDados.add(dados);
                    id++;

                    // Opção 2: adiciona a linha lida ao array, caso não necessite do split
//                    listaQueries.add(line);
                }
            } finally {
                // Fecha o arquivo
                f.close();
            }
        } catch (IOException e) {
            throw new IOException("Falha ao carregar os dados do arquivo!");
        }

        return listaDados;
    }
}
