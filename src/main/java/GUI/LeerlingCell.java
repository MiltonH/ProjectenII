/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.gluonhq.charm.connect.User;
import domain.Leerling;
import domain.LeerlingRepo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

/**
 *
 * @author Milton
 */
public class LeerlingCell extends ListCell<Leerling> {

    private final HBox root = new HBox();
    
    private Label descriptionLabel;
    
    
    public LeerlingCell() {

        this.descriptionLabel = new Label();
        root.getChildren().add(descriptionLabel);
    }

    @Override
    protected void updateItem(Leerling user, boolean empty) {
        super.updateItem(user, empty);
        
        if (empty) {
            setGraphic(null);
        } else {
            if (user.getFamilienaam()!= null) {
                descriptionLabel.setText(user.getFamilienaam()+ " " + user.getVoornaam());
            } else {
                descriptionLabel.setText(user.getVoornaam());
            }
            setGraphic(root);
        }
    }
}
