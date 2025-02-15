package com.sibirajen;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseManager {
    private List<Expense> expenseList;

    private static final Logger logger = Logger.getLogger(ExpenseManager.class.getName());

    public ExpenseManager() {
        this.expenseList = loadExpense();
    }

    private List<Expense> loadExpense() {
        try {
            return CsvHandler.readCsv();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading CSV file" + e.getClass().getSimpleName());
            return new ArrayList<>();
        }
    }

    public void saveExpense(){
        try {
            CsvHandler.writeCsv(this.expenseList);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            logger.log(Level.SEVERE, "Error occurred while writing the CSV file: " + e.getClass().getSimpleName());
        }
    }
}
