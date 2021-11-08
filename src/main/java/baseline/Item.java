package baseline;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    private String task;
    private String completionDate;
    private boolean finished;

    private final checkInfo check = new checkInfo();

    // Creating a list to hold all tasks
    private static final List<Item> toDoList = new ArrayList<>();

    // Constructor
    public Item(String task, String completionDate, boolean finished)
    {
        this.task = task;

        this.finished = finished;

        if(check.checkCompletionDate(completionDate))
        {
            // If completion date is correct assign it
            this.completionDate = completionDate;
        }
        else if(completionDate.equals("") || !check.checkCompletionDate(completionDate))
        {
            // Returns this statement if completion date is blank or not valid
            this.completionDate = "Enter a valid completion date ";
        }

    }

    public void setTask(String task)
    {
        // Setting the task to an object item if correct
        if(check.checkTask(task))
        {
            this.task = task;
        }
    }

    public void setCompletionDate(String completionDate)
    {
        // Setting the completion date to an object item if correct
        if(check.checkCompletionDate(completionDate))
        {
            this.completionDate = completionDate;
        }
    }

    public void setFinished(boolean finished)
    {
        // Setting whether it is finished or not
        this.finished = finished;
    }

    public  String getTask()
    {
        // Used to actually get the task
        return task;
    }

    public String getCompletionDate()
    {
        // Returns the completion date
        return completionDate;
    }

    public boolean getFinished()
    {
        // Returns whether task is finished or not
        return finished;
    }

    public static List<Item> getToDoList()
    {
        // Returns the toDoList
        return toDoList;
    }

    public static void remove(Item task)
    {
        // Removes a task from the current list
        toDoList.remove(task);
    }

}
