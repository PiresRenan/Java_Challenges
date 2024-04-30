package org.example.leitor_csv.app;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.example.leitor_csv.leitor.LeitorCSV;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String arquivoCSV = "kid_iq.csv";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(arquivoCSV)) {
            if (inputStream == null) {
                throw new IOException("Arquivo não encontrado: " + arquivoCSV);
            }

            List<String[]> linhas = LeitorCSV.lerCSV(String.valueOf(new InputStreamReader(inputStream)));
            for (String[] linha : linhas) {
                for (String dado : linha) {
                    System.out.print(dado + "\t");
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}