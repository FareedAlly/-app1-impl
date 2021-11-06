/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;

public class currentToDoListController {

    @FXML
    private Button editList;

    @FXML
    private Button export;

    @FXML
    private Button returnToLists;

    @FXML
    private ListView<?> singleListView;

    @FXML
    private Button taskCompleted;

    @FXML
    private Button viewCompletedTasks;

    @FXML
    private Button viewIncompleteTasks;

    @FXML void returnToListsClicked(ActionEvent event)
    {
        // Return user to AllToDoLists
    }

    @FXML void editListClicked(ActionEvent event)
    {
        // Open up list so user can edit it
        // New class with all the editing controls in it, along with new scene?
    }

    @FXML void exportClicked(ActionEvent event)
    {
        // Create a txt file so the current list can be saved
        // Ask user where they want to save the txt file to
        // How to manipulate directories?
    }

    @FXML void taskCompletedClicked(ActionEvent event)
    {
        // Set the task that was selected as complete
    }

    @FXML void viewCompletedTasksClicked(ActionEvent event)
    {
        // Show all tasks that were completed
    }

    @FXML void viewIncompleteTasks(ActionEvent event)
    {
        // Show all tasks that were incomplete
    }

}
