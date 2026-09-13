import java.util.Scanner;

/**
 * @author Charlie Crocker crockecf@mail.uc.edu
 * @version 1.0
 */

public class SafeInputObject
{
    Scanner pipe;

    /**
     * Constructor for objects of class SafeInputObject
     */
    public SafeInputObject()
    {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor for objects of class SafeInputObject
     * @param in Scanner object to use for input from the user
     */
    public SafeInputObject(Scanner in)
    {
        this.pipe = in;
    }

    /**
     * A method that gets a non-zero-length String from the user.
     *
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public String getNonZeroLenString(String prompt)
    {
        String retString; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.isEmpty());

        return retString;

    }

    /**
     * A method that prompts the user to input any integer. (That is that we don't have any pre-conception
     * of what the range for the integer might be.)
     * @param prompt prompt for the user
     * @return an integer response
     */
    public int getInt(String prompt)
    {
        boolean done = false;
        int val = 0;
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);
            }
        } while(!done);
        return val;
    }

    /**
     * A method that prompts the user to input any double. (That is that we don't have any pre-conception
     * of what the range for the double might be.)
     * @param prompt prompt for the user
     * @return a double response
     */
    public double getDouble(String prompt)
    {
        boolean done = false;
        double val = 0.0;
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                val = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
            }
        } while(!done);
        return val;
    }

    /**
     * A method that prompts the user to input an integer within a specified inclusive range. (inclusive
     * means that low and high are valid inputs)
     * @param prompt prompt for the user
     * @param low the lowest value that is valid
     * @param high the highest value that is valid
     * @return an integer within the specified range
     */
    public int getRangedInt(String prompt, int low, int high)
    {
        boolean done = false;
        int val = 0;
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();
                if(val >= low && val <= high) done = true;
                else System.out.println("Integer must be between " + low + " and " + high);
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);
            }
        } while(!done);
        return val;
    }

    /**
     * A method that prompts the user for a double within a specified range. (inclusive
     * means that low and high are valid inputs)
     * @param prompt prompt for the user
     * @param low the lowest value that is valid
     * @param high the highest value that is valid
     * @return an integer within the specified range
     */
    public double getRangedDouble(String prompt, double low, double high)
    {
        boolean done = false;
        double val = 0.0;
        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
            {
                val = pipe.nextDouble();
                pipe.nextLine();
                if(val >= low && val <= high) done = true;
                else System.out.println("Double must be between " + low + " and " + high);
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
            }
        } while(!done);
        return val;
    }

    /**
     * A method that gets a Yes or No [Y/N] returning true for yes and false for no. It should
     * accept yYnN as valid responses and loop until it gets one of them.
     * @param prompt prompt for the user
     * @return true if user enters 'Y' or 'y', false if user enters 'N' or 'n'
     */
    public boolean getYNConfirm(String prompt)
    {
        boolean done = false;
        String val;
        do
        {
            System.out.print(prompt + "[Y/N]: ");
            val = pipe.nextLine();
            if(val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("N")) done = true;
            else System.out.println("Please enter Y or N");
        }while(!done);
        return val.equalsIgnoreCase("Y");
    }

    /**
     * A method that prompts the user to input a String that matches a RegEx pattern.
     * @param prompt prompt for the user
     * @param regEx regular expression pattern to match
     * @return a String that matches the specified RegEx pattern
     */
    public String getRegExString(String prompt, String regEx)
    {
        boolean done = false;
        String val;
        do
        {
            System.out.print(prompt + ": ");
            val = pipe.nextLine();
            if(val.matches(regEx)) done = true;
            else System.out.println("Please enter a string that matches the pattern " + regEx + " Not: " + val);
        } while(!done);
        return val;
    }

    /**
     * The top and bottom rows consist of a series of asterisks. A message is displayed
     * on the second of three rows The message is centered within the second row, but
     * there are three asterisks at the start and end of the row. The three at the end
     * of the row line up with the series of asterisks on the first and third lines.
     * @param msg the message to display
     */
    public static void prettyHeader(String msg)
    {
        int width = 60;
        for(int i = 0; i < width; i++) System.out.print("*");
        System.out.println();
        int msgLength = msg.length();
        int spaces = (width - 6 - msgLength) / 2;
        System.out.print("***");
        for(int i = 0; i < spaces; i++) System.out.print(" ");
        System.out.print(msg);
        for(int i = 0; i < width - 6 - spaces - msgLength; i++) System.out.print(" ");
        System.out.println("***");
        for(int i = 0; i < width; i++) System.out.print("*");
        System.out.println();
    }
}
