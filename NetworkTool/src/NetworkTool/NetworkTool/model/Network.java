/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktool.NetworkTool.model;

import java.net.InetAddress;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 *
 * @author Nikos
 */
public class Network {

    public Alert alert = new Alert(AlertType.CONFIRMATION);

    public void alert(String i, String j, String iptype) {

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Your IP");
        alert.setHeaderText("Copy ");
        alert.setContentText("That is your "+iptype+" ip address: \n"+j);

        ButtonType buttonTypeOne = new ButtonType("Copy");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            // ... user chose "One"

            ClipboardContent content = new ClipboardContent();
            content.putString(i);
            
            Clipboard.getSystemClipboard().setContent(content);

        } else {
            // ... user chose CANCEL or closed the dialog
            
        }
    }

}
