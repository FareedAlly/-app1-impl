/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class newListController {

    @FXML
    private Button addTask;

    @FXML
    private Button editTask;

    @FXML
    private Button importButton;

    @FXML
    private ListView<?> listDisplay;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button nameList;

    @FXML
    private TextField newTask;

    @FXML
    private Button removeTask;

    @FXML
    private TextField taskDescription;

    @FXML
    private TextField taskDueDate;

    @FXML void addTaskClicked(ActionEvent event)
    {
        // Creates a new task based on entries in the various text fields
    }

    @FXML void editTaskClicked(ActionEvent event)
    {
        // Allow user to edit the information for the task that they chose
    }

    @FXML void importButtonClicked(ActionEvent event)
    {
        // Have user select a file with tasks, and create the subsequent To-Do List
    }

    @FXML void mainMenuButtonClicked(ActionEvent event)
    {
        // Return the user to the mainMenu
    }

    @FXML void removeTaskClicked(ActionEvent event)
    {
        // Remove the selected task from the list
    }

}