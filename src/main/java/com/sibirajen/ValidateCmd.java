package com.sibirajen;

public class ValidateCmd {
    public static void checkAddCmd(String[] cmds) {
        if (cmds.length < 5) {
            System.out.println("Usage: java ExpTracker add -d [argument] -a [argument]");
            return;
        }

        if (!cmds[1].equals("-d") || !cmds[3].equals("-a")) {
            System.out.println("Usage: java ExpTracker add -d [argument] -a [argument]");
            return;
        }
    }

    public static void checkDelCmd(String[] cmds) {
        if(cmds.length < 3) {
            System.out.println("Usage: java ExpTracker delete -i [argument]");
            return;
        }

        if(!cmds[1].equals("-i")) {
            System.out.println("Usage: java ExpTracker delete -i [argument]");
            return;
        }
    }
}
