/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;

public class AllToDoListsController {

    @FXML
    private Button addList;

    @FXML
    private Button deleteList;

    @FXML
    private Button editList;

    @FXML
    private Button exportLists;

    @FXML
    private ListView<?> viewAllLists;

    @FXML
    private Button viewList;

    @FXML void addListClicked(ActionEvent event)
    {
        // Redirects to newList so user can create a new list
    }

    @FXML void deleteListClicked(ActionEvent event)
    {
        // Deletes list user selected from the listView
    }

    @FXML void editListClicked(ActionEvent event)
    {
        // Allows user access to controls that will allow them to edit a list
    }

    @FXML void exportListsClicked(ActionEvent event)
    {
        // Creates a txt file with all the lists that the user selected
        // Ask user where they would like the file to be saved
    }

    @FXML void viewListClicked(ActionEvent event)
    {
        // Redirects to currentToDoLists so user can view singular list
    }

}
