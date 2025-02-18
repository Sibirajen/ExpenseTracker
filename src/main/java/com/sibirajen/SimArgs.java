package com.sibirajen;

public class SimArgs {
    public static void main(String[] args) {
        String[][] commands = {
                {},
                {"abc"},
                {"list"},
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
                {"list"}
        };

        for(String[] command: commands){
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Running command: java ExpTracker " + String.join(" ", command));
            ExpTrackerCLI.main(command);
        }
    }
}
