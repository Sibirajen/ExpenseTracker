package com.sibirajen;

public class ValidateCmd {
    public static boolean checkAddCmd(String[] commands) {
        if (commands.length != 5 || !commands[1].equals("-d") || !commands[3].equals("-a")) {
            System.out.println("Usage: java ExpTracker add -d <description> -a <amount>");
            return false;
        }

        return true;
    }

    public static boolean checkDelCmd(String[] commands) {
        if (commands.length != 3 || !commands[1].equals("-i")) {
            System.out.println("Usage: java ExpTracker delete -i <expense_id>");
            return false;
        }

        return true;
    }

    public static boolean checkSummaryCmd(String[] commands) {
        if (commands.length != 3 || !commands[1].equals("-m")) {
            System.out.println("Usage: java ExpTracker summary -m <month>");
            return false;
        }

        return true;
    }
}
