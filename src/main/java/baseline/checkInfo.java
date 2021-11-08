/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

// The purpose of this class is to check that each task is unique as well as if all the entered info fits the requirements
public class checkInfo
{
    public boolean checkCompletionDate(String completionDate)
    {
        // Checks an entered completion date to see if its valid
        // First check if it fits format of YYYY-MM-DD
        char[] dueDate = completionDate.toCharArray();

        // Above format is 10 chars exactly, so check that it's that length
        if(completionDate.length() != 10)
        {
            return false;
        }

        // Once length is checked, make sure its has correct YYYY MM DD and dashes
        for(int i=0; i<10; i++)
        {
            if(Character.isAlphabetic(dueDate[i]))
            {
                // Check if someone was being sneaky and actually entered YYYY-MM-DD
                return false;
            }

            if((i==4 || i==7) && dueDate[i] != '-')
            {
                // Checks to see if there is a dash at the correct indexes
                return false;
            }

            if(!(Character.isDigit(dueDate[i])))
            {
                if(i==4 || i==7)
                {
                    continue;
                }

                // Checks to see if user entered any special characters
                return false;
            }
        }

        // Once format is checked, then we can test whether there is the correct number of days
        int year = Integer.parseInt(completionDate.substring(0,4));
        int month = Integer.parseInt(completionDate.substring(5,7));
        int day = Integer.parseInt(completionDate.substring(8));

        // Check that month is not grater than 12 and day is not greater than 31
        if(month>12 || day>31)
        {
            return false;
        }

        if((month==4 || month==5 || month==6 || month==9 || month==11) && day>30)
        {
            // Check to see if there are 30 days in the correct months
            return false;
        }

        // If the code reaches this point and the user enters everything correctly, that means it is a leap year
        return (year % 4 != 0 || month != 2 || day <= 29) && (year % 4 == 0 || month != 2 || day <= 28);
    }

    public boolean checkTask(String task)
    {
        // Check if the task is between 1 and 256 characters
        return task.length() > 1 && task.length() < 256;
    }

}
