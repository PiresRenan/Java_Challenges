package com.leitor_csv.leitor;

import com.opencsv.exceptions.CsvException;
import org.example.leitor_csv.leitor.LeitorCSV;
import org.example.leitor_csv.model.Data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSVTest {

    private LeitorCSV reader;

    @BeforeEach
    void setUp() throws IOException {
        reader = new LeitorCSV("kid_iq.csv");
    }

    @Test
    void testLeitorCSV() throws IOException, CsvException {
        List<Data> linhas = reader.readDataFromCSV();
        List<String> childIQScore = new ArrayList<>();
        List<String> motherEducation = new ArrayList<>();
        List<String> motherIQ = new ArrayList<>();
        List<String> motherJob = new ArrayList<>();
        List<String> motherAge = new ArrayList<>();

        int i = 0;
        for (Data data : linhas) {
            if (data.getIndex() < 4) {
                childIQScore.add(data.getChildIQScore());
                motherEducation.add(data.getMotherEducation());
                motherIQ.add(data.getMotherIQ());
                motherJob.add(data.getMotherJob());
                motherAge.add(data.getMotherAge());

            }
            i++;
        }

        i = 0;
        for (Data data : linhas) {
            if (data.getIndex() < 4) {
                Assertions.assertEquals(i, data.getIndex());
                Assertions.assertEquals(childIQScore.get(i), data.getChildIQScore());
                Assertions.assertEquals(motherEducation.get(i), data.getMotherEducation());
                Assertions.assertEquals(motherIQ.get(i), data.getMotherIQ());
                Assertions.assertEquals(motherJob.get(i), data.getMotherJob());
                Assertions.assertEquals(motherAge.get(i), data.getMotherAge());
            }
            i++;
        }
    }

}
