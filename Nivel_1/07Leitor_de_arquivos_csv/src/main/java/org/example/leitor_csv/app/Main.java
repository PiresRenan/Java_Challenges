package org.example.leitor_csv.app;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

import com.opencsv.exceptions.CsvException;

import org.example.leitor_csv.leitor.LeitorCSV;
import org.example.leitor_csv.model.Data;

public class Main {
    public static void main(String[] args) {
        try {
            LeitorCSV leitor = new LeitorCSV("kid_iq.csv");

            List<Data> linhas = leitor.readDataFromCSV();
            for (Data data : linhas) {
                if (data.getIndex() < 4) {
                    System.out.println(data);
                }
            }

            List<String[]> all_csv = leitor.lerCSV();
            for (String[] row : all_csv) {
                if (Objects.equals(row[0], "") || Integer.parseInt(row[0]) < 4) {
                    System.out.println(Arrays.toString(row));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }
}