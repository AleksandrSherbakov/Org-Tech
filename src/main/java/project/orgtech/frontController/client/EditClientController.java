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
public class EditClientController implements DataReceiver<Client> {
    private Client client;
    @Override
    public void setData(Client client) {
        this.client = client;
        loadClientData();
    }

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
        if (client == null) {
            sceneManager.showAlert("Ошибка", "Тип не найден");
            return;
        }

        String newName = nameField.getText();
        String newDescription = descriptionField.getText();

        client.setBio(newName);
        client.setPhone(newDescription);

        // Вызываем сервис для сохранения изменений
        clientService.updateClient(client);

        // Показываем сообщение об успешном сохранении
        sceneManager.showAlert("Успешно", "Тип сохранен");

        sceneManager.openScene(SaveButton, FxmlView.CLIENT_PANEL);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.CLIENT_INFO, client);
    }

    private void loadClientData() {
        if (client != null) {
            nameField.setText(client.getBio());
            descriptionField.setText(client.getPhone());
        }
    }

}
