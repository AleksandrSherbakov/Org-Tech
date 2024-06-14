package project.orgtech.frontController;

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
import project.orgtech.models.Application;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private SceneManager sceneManager;

    @Autowired
    private ApplicationService applicationService;

    @FXML
    private ListView<Application> ApplicationListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button CreateButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;

    private ObservableList<Application> applicationObservableList;

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
        sceneManager.openScene(CreateButton, FxmlView.APPLICATION_ADD);
    }

    public void initialize() {
        // Загрузите данные из базы данных
        List<Application> types = loadDataFromDatabase();

        // Преобразуйте список в ObservableList
        applicationObservableList = FXCollections.observableArrayList(types);

        // Установите ObservableList в ListView
        ApplicationListView.setItems(applicationObservableList);

        // Настройте отображение элементов списка
        ApplicationListView.setCellFactory(param -> new ListCell<Application>() {
            @Override
            protected void updateItem(Application application, boolean empty) {
                super.updateItem(application, empty);
                if (empty || application == null || application.getName() == null) {
                    setText(null);
                } else {
                    setText(application.getName());
                }
            }
        });

        ApplicationListView.setOnMouseClicked(this::handleListClick);
    }

    private List<Application> loadDataFromDatabase() {
        return applicationService.getAllApplication();
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Application selectedType = ApplicationListView.getSelectionModel().getSelectedItem();
            if (selectedType != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.MAIN, selectedType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
