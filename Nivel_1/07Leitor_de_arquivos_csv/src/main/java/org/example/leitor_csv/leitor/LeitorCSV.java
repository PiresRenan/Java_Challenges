package org.example.leitor_csv.leitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.example.leitor_csv.model.Data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LeitorCSV {

    private final Path caminho_arquivo;

    public LeitorCSV(String arquivoCSV) {
        this.caminho_arquivo = Paths.get("src", "main", "resources", arquivoCSV);
    }

    public List<Data> readDataFromCSV() throws IOException, CsvException {
        List<Data> dataList = new ArrayList<>();
        try (InputStream inputStream = Files.newInputStream(this.caminho_arquivo);
             CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            List<String[]> linhas = reader.readAll();
            for (String[] linha : linhas) {
                Data data = createDataFromCSVLine(linha);
                dataList.add(data);
            }
        }
        return dataList;
    }

    private Data createDataFromCSVLine(String[] line) {
        Data data = new Data();
        try{
            data.setIndex(Integer.parseInt(line[0]));
        }catch (NumberFormatException e){
            data.setIndex(0);
        }
        data.setChildIQScore(line[1]);
        data.setMotherEducation(line[2]);
        data.setMotherIQ(line[3]);
        data.setMotherJob(line[4]);
        data.setMotherAge(line[5]);
        return data;
    }

    public List<String[]> lerCSV() throws IOException, CsvException {
        try (InputStream inputStream = Files.newInputStream(this.caminho_arquivo);
             CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            return reader.readAll();
        }
    }
}
