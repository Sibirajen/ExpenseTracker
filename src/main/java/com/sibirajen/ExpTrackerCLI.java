package com.sibirajen;

/**
 * Hello world!
 *
 */
public class ExpTrackerCLI
{
    public static void main( String[] args )
    {
        if(args.length < 1) {
            System.out.println("Usage: java ExpTracker <command>");
            return;
        }
        ExpenseManager manager = new ExpenseManager();
        switch(args[0]) {
            case "add": {
                if (!ValidateCmd.checkAddCmd(args)) return;
                String name = args[2];
                double amount;
                try {
                    amount = Double.parseDouble(args[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount format. Please enter a valid number.");
                    return;
                }
                if (amount < 0) {
                    System.out.println("Amount cannot be negative.");
                    return;
                }
                manager.addExpense(name, amount);
                break;
            }
            case "list":
                manager.list();
                break;
            default:
                System.out.println("Usage: java ExpTracker <command>");
        }
        manager.saveExpense();
    }
}
