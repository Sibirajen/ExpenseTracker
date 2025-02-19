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
    private static final Path FILE_PATH = Path.of("C:/Users/"+ System.getProperty("user.name") +"/Downloads/trackr.csv");

    public static void writeCsv(List<Expense> expense) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        StatefulBeanToCsv<Expense> beanWriter;
        BufferedWriter writer = Files.newBufferedWriter(FILE_PATH);
        beanWriter = new StatefulBeanToCsvBuilder<Expense>(writer)
                .withApplyQuotesToAll(false)
                .build();
        beanWriter.write(expense);
        writer.close();
    }

    public static List<Expense> readCsv() throws IOException {
        createFile();
        BufferedReader reader = Files.newBufferedReader(FILE_PATH);
        List<Expense> expenseList =  new CsvToBeanBuilder<Expense>(reader)
                .withType(Expense.class)
                .build().parse();
        reader.close();
        return expenseList;
    }

    public static void createFile() throws IOException {
        if(!Files.exists(FILE_PATH)){
            Files.createFile(FILE_PATH);
        }
    }
}
