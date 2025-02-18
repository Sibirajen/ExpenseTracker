package com.sibirajen;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.DateFormatSymbols;
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
        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return;
        }
        int id = ++uniqueId;
        Expense expense = new Expense(id, name, amount);
        expenseList.add(expense);
        System.out.println("# Expense added successfully (ID: " + id + " )");
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
        Expense.printHeader();
        for (Expense expense : expenseList) {
            System.out.print(expense);
        }
    }

    public void deleteExpense(int id) {
        for (int i = 0; i < expenseList.size(); i++) {
            Expense expense = expenseList.get(i);
            if (expense.getId() == id) {
                expenseList.remove(i);
                System.out.println("# Expense deleted successfully");
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void summary() {
        if(expenseList.isEmpty()){
            System.out.println("No data to print");
            return;
        }
        double total = 0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }
        System.out.printf("# Total expenses: Rs.%.2f\n", total);
    }

    public void summary(int month) {
        if(month < 1 || month > 12){
            System.out.println("Enter a valid month");
            return;
        }
        double total = 0;
        for (Expense expense : expenseList) {
            if(expense.getCreatedAt().getMonthValue() == month){
                total += expense.getAmount();
            }
        }
        String monthStr = new DateFormatSymbols().getMonths()[month - 1];
        System.out.printf("# Total expenses for %s : Rs.%.2f\n", monthStr, total);
    }
}
