package project.orgtech.frontController.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Client;
import project.orgtech.service.client.ClientService;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class AddClientApplicationController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private SceneManager sceneManager;
    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button SaveButton;

    @FXML
    private Button BackButton;

    @FXML
    private void handleSave(ActionEvent event) throws IOException {

        Client client = new Client();
        client.setBio(nameField.getText());
        client.setPhone(descriptionField.getText());

        // Вызываем сервис для сохранения изменений
        clientService.add(client);

        // Показываем сообщение об успешном сохранении
        sceneManager.showAlert("Успешно", "Клиент создан");
        client = null;
        //sceneManager.openScene(SaveButton, FxmlView.APPLICATION_ADD);
        sceneManager.closeScene(SaveButton);

    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        //sceneManager.openScene(BackButton, FxmlView.APPLICATION_ADD);
        sceneManager.closeScene(BackButton);
    }

}
