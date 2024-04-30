package org.example.leitor_csv.leitor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import org.example.leitor_csv.model.Data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LeitorCSV {
    private String arquivoCSV;
    public LeitorCSV(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }
    public List<Data> readDataFromCSV() throws IOException {
        List<Data> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] line;
            boolean skipHeader = true;
            while ((line = reader.readNext()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                Data data = createDataFromCSVLine(line);
                dataList.add(data);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }

    private Data createDataFromCSVLine(String[] line) {
        Data data = new Data();
        data.setIndex(Integer.parseInt(line[0]));
        data.setChildIQScore(Integer.parseInt(line[1]));
        data.setMotherEducation(Integer.parseInt(line[2]));
        data.setMotherIQ(Integer.parseInt(line[3]));
        data.setMotherJob(line[4]);
        data.setMotherAge(Integer.parseInt(line[5]));
        return data;
    }

    public static List<String[]> lerCSV(String arquivoCSV) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            return reader.readAll();
        }
    }
}
