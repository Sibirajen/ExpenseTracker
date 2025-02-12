package com.sibirajen;

public class SimArgs {
    public static void main(String[] args) {
        String[][] commands = {
                {},
                {"add"},
                {"add","Lunch","20"},
                {"add","--d","Lunch","--a","20"},
                {"add","-d","Lunch","-a","20"}
        };

        for(String[] command: commands){
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Running command: java ExpTracker " + String.join(" ", command));
            ExpTrackerCLI.main(command);
        }
    }
}
