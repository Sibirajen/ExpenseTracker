package com.sibirajen;

public class ValidateCmd {
    public static boolean checkAddCmd(String[] commands) {
        if (commands.length < 5) {
            System.out.println("Usage: java ExpTracker add -d [argument] -a [argument]");
            return false;
        }

        if (!commands[1].equals("-d") || !commands[3].equals("-a")) {
            System.out.println("Usage: java ExpTracker add -d [argument] -a [argument]");
            return false;
        }

        return true;
    }

    public static boolean checkDelCmd(String[] commands) {
        if(commands.length < 3) {
            System.out.println("Usage: java ExpTracker delete -i [argument]");
            return false;
        }

        if(!commands[1].equals("-i")) {
            System.out.println("Usage: java ExpTracker delete -i [argument]");
            return false;
        }

        return true;
    }

    public static boolean checkUpdateCmd(String[] commands) {
        if(commands.length < 3) {
            System.out.println("Usage: java ExpTracker update -i [argument]");
            return false;
        }

        if(!commands[1].equals("-i")) {
            System.out.println("Usage: java ExpTracker update -i [argument]");
            return false;
        }

        return true;
    }
}
