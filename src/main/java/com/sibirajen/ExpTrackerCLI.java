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
                    System.out.println("Invalid amount. Please enter a valid Number.");
                    return;
                }
                manager.addExpense(name, amount);
                break;
            }
            case "delete":{
                if(!ValidateCmd.checkDelCmd(args)) return;
                int id;
                try{
                    id = Integer.parseInt(args[2]);
                } catch (NumberFormatException e){
                    System.out.println("Invalid number. Please enter a valid Id.");
                    return;
                }
                manager.deleteExpense(id);
                break;
            }
            case "list":{
                manager.list();
                break;
            }
            case "summary":{
                if(args.length == 1){
                    manager.summary();
                    return;
                }
                if(!ValidateCmd.checkSummaryCmd(args)) return;
                int month;
                try{
                    month = Integer.parseInt(args[2]);
                } catch (NumberFormatException e){
                    System.out.println("Invalid number. Please enter a valid month.");
                    return;
                }
                manager.summary(month);
                break;
            }
            case "help":{
                if(args.length != 1){
                    System.out.println("Usage: java ExpTracker help");
                    return;
                }
                printHelp();
                break;
            }
            default:
                System.out.println("Usage: java ExpTracker <command>");
                break;
        }
        manager.saveExpense();
    }

    private static void printHelp() {
        System.out.println("\nExpense Tracker CLI - Help");
        System.out.println("============================");
        System.out.println("Usage: java ExpTracker <command> [options]");
        System.out.println("\nAvailable Commands:");
        System.out.println("  add -d <description> -a <amount>    Add a new expense");
        System.out.println("  delete -i <expense_id>             Delete an expense by ID");
        System.out.println("  list                               List all expenses");
        System.out.println("  summary                            Show total expenses");
        System.out.println("  summary -m <month>                 Show expenses for a specific month");
        System.out.println("  help                               Show this help message");
    }
}
