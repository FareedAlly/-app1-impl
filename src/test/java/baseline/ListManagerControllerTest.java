package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerControllerTest {

    @Test
    void createList()
    {
        ListManagerController controller = new ListManagerController();
        Item.getToDoList().clear();
        for (int i = 0; i < 10; i++)
        {
            String desc = "falseItem" + i;
            Item.getToDoList().add(new Item(desc, "", false));
        }
        for (int i = 0; i < 10; i++)
        {
            String desc = "trueItem" + i;
            Item.getToDoList().add(new Item(desc, "", true));
        }

        ObservableList<Item> completedItems = FXCollections.observableArrayList();
        completedItems = controller.createList(true, completedItems);
        assertEquals(10, completedItems.size());

        ObservableList<Item> incompleteItems = FXCollections.observableArrayList();
        incompleteItems = controller.createList(false, incompleteItems);
        assertEquals(10, incompleteItems.size());
        Item.getToDoList().clear();
    }

    @Test
    void addItemToList()
    {
        ListManagerController controller = new ListManagerController();
        Item.getToDoList().clear();
        for (int i = 0; i < 50; i++)
        {
            String desc = "item" + i;
            controller.addItemToList(desc, "", false);
        }
        assertEquals(50, Item.getToDoList().size());
        Item.getToDoList().clear();
    }

}