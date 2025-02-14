package com.sibirajen;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvHandler {
    private static final Path FILE_PATH = Path.of("File.csv");

    public static void writeCsv(List<Bean> bean) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        createFile();
        BufferedWriter writer = Files.newBufferedWriter(FILE_PATH);
        StatefulBeanToCsv<Bean> beanWriter = new StatefulBeanToCsvBuilder<Bean>(writer)
                .withApplyQuotesToAll(false)
                .build();
        beanWriter.write(bean);
    }

    public static List<Bean> readCsv() throws IOException {
        createFile();
        BufferedReader reader = Files.newBufferedReader(FILE_PATH);
        return new CsvToBeanBuilder<Bean>(reader)
                .withType(Bean.class)
                .build().parse();
    }

    public static void createFile() throws IOException {
        if(!Files.exists(FILE_PATH)){
            Files.createFile(FILE_PATH);
        }
    }
}
