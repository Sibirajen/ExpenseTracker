package com.sibirajen;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseManager {
    private final List<Expense> expenseList;
    private int uniqueId;

    private static final Logger logger = Logger.getLogger(ExpenseManager.class.getName());

    public ExpenseManager() {
        this.expenseList = loadExpense();
        this.uniqueId = getUniqueId();
    }

    public void addExpense(String name, double amount){
        int id = ++uniqueId;
        Expense expense = new Expense(id, name, amount);
        expenseList.add(expense);
        System.out.println("Expense added successfully (ID: " + id + " )");
    }

    private int getUniqueId(){
        int size = expenseList.size();
        if(expenseList.isEmpty()){
            return 99;
        }
        Expense expense = expenseList.get(size-1);
        return expense.getId();
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
            CsvHandler.writeCsv(expenseList);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            logger.log(Level.SEVERE, "Error occurred while writing the CSV file: " + e.getClass().getSimpleName());
        }
    }

    public void list() {
        if(expenseList.isEmpty()){
            System.out.println("No data to print");
            return;
        }
        System.out.println("# ID  Date       Description  Amount");
        for (Expense e : expenseList) {
            System.out.printf("# %-3d %-10s %-12s ₹%.2f\n", e.getId(), e.getCreatedAt(), e.getName(), e.getAmount());
        }
    }
}
