package project.orgtech.frontController.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Client;
import project.orgtech.service.client.ClientService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.util.List;

@Controller
public class PanelClientController {

    @Autowired
    private SceneManager sceneManager;

    @Autowired
    private ClientService clientService;

    @FXML
    private ListView<Client> ClientListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button CreateButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;

    private ObservableList<Client> clientObservableList;

    @FXML
    private void handleMyApplicationButton(ActionEvent event) throws IOException {
        sceneManager.openScene(MyApplicationButton, FxmlView.MAIN);
    }

    @FXML
    private void handleCategoryButton(ActionEvent event) throws IOException {
        sceneManager.openScene(CategoryButton, FxmlView.CATEGORY);
    }

    @FXML
    private void handleReportsButton(ActionEvent event) throws IOException {
        //sceneManager.openScene(ReportsButton, FxmlView.REPORTS);
    }

    @FXML
    private void handleCreateButton(ActionEvent event) throws IOException {
        sceneManager.openScene(CreateButton, FxmlView.CLIENT_ADD);
    }

    public void initialize() {
        // Загрузите данные из базы данных
        List<Client> clients = loadDataFromDatabase();

        // Преобразуйте список в ObservableList
        clientObservableList = FXCollections.observableArrayList(clients);

        // Установите ObservableList в ListView
        ClientListView.setItems(clientObservableList);

        // Настройте отображение элементов списка
        ClientListView.setCellFactory(param -> new ListCell<Client>() {
            @Override
            protected void updateItem(Client client, boolean empty) {
                super.updateItem(client, empty);
                if (empty || client == null || client.getBio() == null) {
                    setText(null);
                } else {
                    setText(client.getBio());
                }
            }
        });

        ClientListView.setOnMouseClicked(this::handleListClick);
    }

    private List<Client> loadDataFromDatabase() {
        return clientService.getAll();
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Client selectedClient = ClientListView.getSelectionModel().getSelectedItem();
            if (selectedClient != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.CLIENT_INFO, selectedClient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
