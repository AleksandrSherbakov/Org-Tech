package project.orgtech.frontController.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;


import project.orgtech.models.Client;
import project.orgtech.service.client.ClientService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class InfoClientController implements DataReceiver<Client> {
    private Client client;

    @Autowired
    ClientService clientService;

    @Autowired
    SceneManager sceneManager;

    @FXML
    private Button BackButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private TextField nameField ;

    @FXML
    private TextField descriptionField;

    @Override
    public void setData(Client client) {
        this.client = client;
        loadClientData();
    }

    @FXML
    private void initialize() {
    }
    @FXML
    private void handleEditButton(ActionEvent event) throws IOException {
        sceneManager.openScene(EditButton, FxmlView.CLIENT_EDIT, client);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.CLIENT_PANEL);
    }
    @FXML
    private void handleDeleteButton(ActionEvent event) throws IOException {
        if (client != null) {
            clientService.deleteClient(client.getId());
        }
        sceneManager.openScene(DeleteButton, FxmlView.CLIENT_PANEL);
    }

    private void loadClientData() {
        if (client != null) {
            nameField.setText(client.getBio());
            descriptionField.setText(client.getPhone());
        }
    }
}
