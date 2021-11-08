/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.util.converter.BooleanStringConverter;

import java.io.*;


public class ListManagerController
{
    private int index = 0;
    checkInfo check = new checkInfo();

    @FXML private Button addTask;
    @FXML private Button clearEntireList;
    @FXML private TableColumn<Item, Boolean> completedColumn;
    @FXML private TextField completionDate;
    @FXML private TableColumn<Item, String> completionDateColumn;
    @FXML private TableView<Item> listView;
    @FXML private Button loadButton;
    @FXML private Button removeTask;
    @FXML private Button saveButton;
    @FXML private CheckBox showCompletedTasks;
    @FXML private CheckBox showIncompleteTasks;
    @FXML private VBox task;
    @FXML private CheckBox taskCompletedCheckBox;
    @FXML private TextField taskName;
    @FXML private TableColumn<Item, String> tasksColumn;
    @FXML private Label status;

    @FXML
    void start()
    {
        // Required to initialize and add tasks to the table
        tasksColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tasksColumn.setOnEditCommit(event ->
        {
            // If description is valid, then add it to the table
            if(check.checkTask(event.getNewValue()))
            {
                Item item = event.getRowValue();
                item.setTask(event.getNewValue());

                status.setText("Task updated. ");
            }

            else
            {
                status.setText("Task not updated. ");
                listView.refresh();
            }
        });

        completionDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        completionDateColumn.setOnEditCommit(event ->
        {
            // If description is valid, then add it to the table
            if(check.checkCompletionDate(event.getNewValue()))
            {
                Item item = event.getRowValue();
                item.setCompletionDate(event.getNewValue());

                status.setText("Completion Date updated. ");
            }

            else
            {
                status.setText("Completion Date not updated. ");
                listView.refresh();
            }
        });

        completedColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));

        completedColumn.setOnEditCommit(event ->
        {
            Item item = event.getRowValue();
            item.setFinished(event.getNewValue());

            listView.refresh();
        });
    }

    @FXML
    void addTaskClicked(ActionEvent event)
    {
        // Create task based on users input in task text, completion date, and whether it is already completed.
        // Call createTask method
        createTask();
    }

    private void clear()
    {
        taskName.clear();
        completionDate.clear();
        taskCompletedCheckBox.setSelected(false);
    }

    private void display()
    {
        // Display task and add it to the table at the next index
        tasksColumn.setCellValueFactory(new PropertyValueFactory<>("task"));
        completionDateColumn.setCellValueFactory(new PropertyValueFactory<>("completionDate"));
        completedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));

        listView.getItems().add(Item.getToDoList().get(index));
        index++;
    }

    public void addItemToList(String task, String completionDate, boolean completed)
    {
        //add a new item to the List using the passed in description, dueDate, and boolean
        Item.getToDoList().add(new Item(task, completionDate, completed));
    }

    public void addTaskAndDisplay(String task, String completionDate, boolean completed)
    {
        // Allow the user to enter a task with no completion date, but alert the user that they are doing so
        if(completionDate.equals(""))
        {
            status.setText("Task has no completion date. ");
            addItemToList(task, completionDate, completed);
            // Call method to display task
            display();
        }

        // If completionDate invalid, that means no completion date, add it but let user know
        else if(!check.checkCompletionDate(completionDate))
        {
            status.setText("Item added with no due date. ");
            addItemToList(task, completionDate, completed);
            display();
        }

        // Add item if everything is fine
        else
        {
            status.setText("Item added to list! ");
            addItemToList(task, completionDate, completed);
            display();
        }

        // Call method that clears up the textfields for new task
        clear();
    }

    public void createTask()
    {
        // Check first to see if user is entering a task that is currently in the list
        boolean copy = false;
        if(check.checkTask(taskName.getText()))
        {
            // Go through list and make sure task isnt already there
            // If there is one already in list, then tell user there it is on list
            if(!(Item.getToDoList().isEmpty()))
            {
                for(Item task : Item.getToDoList())
                {
                    if(task.getTask().equals(taskName.getText()))
                    {
                        status.setText("Task is already on the list. ");
                        copy = true;
                    }
                }

                if(!copy)
                {
                    // If not copy, add the task to the list by calling method
                    addTaskAndDisplay(taskName.getText(), completionDate.getText(), taskCompletedCheckBox.isSelected());
                }
            }

            // If list is empty, then no need to check if task is copy
            else
            {
                addTaskAndDisplay(taskName.getText(), completionDate.getText(), taskCompletedCheckBox.isSelected());
            }

        }

        // If task is invalid, alert user
        else
        {
            status.setText("Task invalid. Try again. ");
        }

    }

    @FXML
    void clearEntireListClicked(ActionEvent event)
    {
        // Clear the array list of tasks
        Item.getToDoList().clear();

        // Clear the table view
        listView.getItems().clear();

        // Reset the index to 0 and clear
        index = 0;
        clear();

    }

    public void loadFile(File file) throws FileNotFoundException
    {
        // Create filereader to read file
        FileReader reader = new FileReader(file);

        // Clear table to make sure it only shows tasks from file
        Item.getToDoList().clear();
        if(this.listView != null)
        {
            listView.getItems().clear();
        }

        index = 0;

        try(BufferedReader temp = new BufferedReader(reader))
        {
            String info;
            boolean check;

            while((info = temp.readLine()) != null)
            {
                // Make an array of values
                String[] values = info.split(",");

                //Array length is 3, since 3 columns. If not that then incorrect file
                if(values.length != 3)
                {
                    if(this.status != null)
                    {
                        status.setText("Incompatible File. ");
                    }
                    break;
                }

                // If correct, add information from file to list
                else
                {
                    check = !values[2].equals("false");
                    Item.getToDoList().add(new Item(values[0], values[1], check));
                }
            }

        } catch (IOException exception)
        {
            // If error, let user know
            if(this.status != null)
            {
                status.setText("File not found. ");
            }

            exception.printStackTrace();
        }
    }

    @FXML
    void loadButtonClicked(ActionEvent event) throws FileNotFoundException
    {
        // Use filechooser to create file object
        FileChooser file = new FileChooser();

        file.setTitle("Load file (.txt)");

        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File selectedFile = file.showOpenDialog(listView.getScene().getWindow());

        // Create new file with all info on file, do this in a method
        loadFile(selectedFile);

        // Send all this info to the list in order to create new one
        for(int i=0; i<Item.getToDoList().size(); i++)
        {
            // Display items
            display();

        }
    }

    @FXML
    void removeTaskClicked(ActionEvent event)
    {
        Item task = listView.getSelectionModel().getSelectedItem();

        if(task != null)
        {
            // Remove item from list
            index--;

            // Remove from table
            listView.getItems().remove(task);
        }

        // If user clicked button without selecting task, tell them so
        else
        {
            status.setText("No task selected to remove. ");
        }
    }

    @FXML
    void saveButtonClicked(ActionEvent event) throws FileNotFoundException
    {
        // Use a filechooser object and ask user where they want to save file
        FileChooser file = new FileChooser();
        file.setTitle("Save your To Do List (.txt)");

        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        // Pass all the info of the current list info this file
        File selectedFile = file.showOpenDialog(listView.getScene().getWindow());

        if(this.status != null)
        {
            status.setText("List saved! ");
        }

        try(PrintWriter writer = new PrintWriter(selectedFile))
        {
            // For each item, write down all its info
            // Seperate by comma, and copy info to table
            for(Item item : Item.getToDoList())
            {
                writer.println(item.getTask() + "," + item.getCompletionDate() + "," + item.getFinished());
            }
        } catch(FileNotFoundException exception)
        {
            // If error, let user know
            if(this.status != null)
            {
                status.setText("File not found. ");
            }
        }

    }

    public ObservableList<Item> createList(boolean completed, ObservableList<Item> tasks)
    {
        tasks.clear();

        // If the tasks have the same value for completed, add those taks to the list
        for(Item item: Item.getToDoList())
        {
            if(completed == item.getFinished())
            {
                tasks.add(item);
            }
        }

        return tasks;
    }

    @FXML
    void showCompletedTasksClicked(ActionEvent event)
    {
        // Make a list with only tasks that are completed
        ObservableList<Item> completedTasks = FXCollections.observableArrayList();

        if(showCompletedTasks.isSelected())
        {
            // Have it display in listView
            // First need to remove all the items in listView and then display only completed
            showIncompleteTasks.setSelected(false);

            listView.getItems().clear();

            // Creating a list with only completed tasks
            createList(true, completedTasks);

            listView.refresh();
        }

        listView.setItems(completedTasks);

        if(!showIncompleteTasks.isSelected())
        {
            // Uncheck the checkbox
            listView.getItems().clear();

            // Add all items to the table
            for(Item item : Item.getToDoList())
            {
                listView.getItems().add(Item.getToDoList().get(Item.getToDoList().indexOf(item)));
            }

            listView.refresh();
        }
    }

    @FXML
    void showIncompleteTasksClicked(ActionEvent event)
    {
        // Make a list with only tasks that are incomplete
        ObservableList<Item> incompleteTasks = FXCollections.observableArrayList();

        if(showIncompleteTasks.isSelected())
        {
            // Have it display in listView
            // First need to remove all the items in listView and then display only incomplete
            showCompletedTasks.setSelected(false);

            listView.getItems().clear();

            createList(false, incompleteTasks);

            listView.refresh();
        }

        listView.setItems(incompleteTasks);

        if(!showIncompleteTasks.isSelected())
        {
            // Uncheck the checkbox
            listView.getItems().clear();

            // Add all items to the table
            for(Item item : Item.getToDoList())
            {
                listView.getItems().add(Item.getToDoList().get(Item.getToDoList().indexOf(item)));
            }

            listView.refresh();
        }
    }
}