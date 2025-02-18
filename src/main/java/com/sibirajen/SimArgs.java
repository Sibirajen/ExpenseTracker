package com.sibirajen;

public class SimArgs {
    public static void main(String[] args) {
        String[][] commands = {
                {},
                {"abc"},
                {"list"},
                {"summary"},
                {"add"},
                {"add","Lunch","20"},
                {"add","--d","Lunch","--a","20"},
                {"add","-d","Lunch","-a","abc"},
                {"add","-d","Lunch","-a","-20"},
                {"add","-d","Lunch","-a","20"},
                {"add","-d","Snacks","-a","10"},
                {"add","-d","Ticket","-a","30"},
                {"list"},
                {"delete"},
                {"delete","100"},
                {"delete","-i","abc"},
                {"delete","--i","100"},
                {"delete","-i","100"},
                {"delete","-i","100"},
                {"list"},
                {"summary"},
                {"summary","2"},
                {"summary","--m","2"},
                {"summary","-m","abc"},
                {"summary","-m","2"},
                {"help"}
        };

        for(String[] command: commands){
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Running command: java ExpTracker " + String.join(" ", command));
            ExpTrackerCLI.main(command);
        }
    }
}
