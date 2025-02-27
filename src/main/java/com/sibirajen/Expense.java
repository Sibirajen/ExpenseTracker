package com.sibirajen;


import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class Expense {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private double amount;
    @CsvBindByPosition(position = 3)
    @CsvDate("dd.MM.yyyy")
    private LocalDate createdAt;

    public Expense() {
    }

    public Expense(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public static void printHeader(){
        String ID = "Id";
        String DATE = "Date";
        String NAME = "Description";
        String AMOUNT = "Amount";
        System.out.printf("# %-3s %-10s %-12s %s\n", ID, DATE, NAME, AMOUNT);
    }

    @Override
    public String toString() {
        return String.format("# %-3d %-10s %-12s Rs.%.2f\n", id, createdAt, name, amount);
    }
}
