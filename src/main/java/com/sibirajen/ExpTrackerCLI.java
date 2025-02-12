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

        switch((args[0])) {
            case "add": {
                if (!ValidateCmd.checkAddCmd(args)) return;
                // add function
                System.out.println("Success");
                break;
            }
            default:
                System.out.println("Usage: java ExpTracker <command>");
        }
    }
}
