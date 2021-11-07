package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class ListManagerController
{
    @FXML
    private Button addTask;

    @FXML
    private Button clearEntireList;

    @FXML
    private TableColumn<?, ?> completedColumn;

    @FXML
    private TextField completionDate;

    @FXML
    private TableColumn<?, ?> completionDateColumn;

    @FXML
    private TableView<?> listView;

    @FXML
    private Button loadButton;

    @FXML
    private Button removeTask;

    @FXML
    private Button saveButton;

    @FXML
    private CheckBox showCompletedTasks;

    @FXML
    private CheckBox showIncompleteTasks;

    @FXML
    private VBox task;

    @FXML
    private CheckBox taskCompletedCheckBox;

    @FXML
    private TextField taskName;

    @FXML
    private TableColumn<?, ?> tasksColumn;

    @FXML
    void addTaskClicked(ActionEvent event)
    {
        // Create task based on users input in task text, completion date, and whether it is already completed.

    }

    @FXML
    void clearEntireListClicked(ActionEvent event)
    {
        // Clear the array list of tasks
        // Clear the table view
        // Do all this in method?

    }

    @FXML
    void loadButtonClicked(ActionEvent event)
    {
        // Use filechooser to create file object
        // Create new file with all info on file
        // Send all this info to the list in order to create new one
        // Display items

    }

    @FXML
    void removeTaskClicked(ActionEvent event)
    {
        // Remove an item from the current list
        // Do this in a method?

    }

    @FXML
    void saveButtonClicked(ActionEvent event)
    {
        // Use a filechooser object and ask user where they want to save file
        // Pass all the info of the current list info this file
        // Use method?


    }

    @FXML
    void showCompletedTasksClicked(ActionEvent event)
    {
        // Make a list with only tasks that are completed
        // Have it display in listView
        // First need to remove all the items in listView and then display only completed

    }

    @FXML
    void showIncompleteTasksClicked(ActionEvent event)
    {
        // Make a list with only tasks that are incomplete
        // Have it display in listView
        // First need to remove all the items in listView and then display only incomplete

    }
}
