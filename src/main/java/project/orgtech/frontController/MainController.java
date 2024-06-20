package project.orgtech.frontController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
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
    @FXML
    private Button MasterArea;

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
        sceneManager.getReports(ReportsButton);
    }

    @FXML
    private void handleCreateButton(ActionEvent event) throws IOException {
        sceneManager.openScene(CreateButton, FxmlView.APPLICATION_ADD);
    }
    @FXML
    private void handleMasterArea(ActionEvent event) throws IOException {
        sceneManager.openScene(CreateButton, FxmlView.MASTER_INFO);
    }

    @FXML
    public void initialize() {
        // Load data from the database
        List<Application> applications = loadDataFromDatabase();

        // Sort applications: In Progress first, then Completed
        applications.sort((a1, a2) -> {
            if (1L==a1.getStatus().getId() && 2L==a2.getStatus().getId()) {
                return -1;
            } else if (2L==a2.getStatus().getId() && 1L==a1.getStatus().getId()) {
                return 1;
            } else {
                return 0;
            }
        });

        // Convert list to ObservableList
        applicationObservableList = FXCollections.observableArrayList(applications);

        // Set ObservableList to ListView
        ApplicationListView.setItems(applicationObservableList);

        // Set ListView cell factory for custom rendering
        ApplicationListView.setCellFactory(param -> new ListCell<Application>() {
            @Override
            protected void updateItem(Application application, boolean empty) {
                super.updateItem(application, empty);
                if (empty || application == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    HBox hBox = new HBox(10); // Spacing between elements
                    Text nameText = new Text(application.getName());
                    Text statusText = new Text(application.getStatus().getName());

                    HBox.setHgrow(nameText, Priority.ALWAYS); // Push status text to the right
                    nameText.setWrappingWidth(430); // Adjust this width as needed

                    hBox.getChildren().addAll(nameText, statusText);
                    hBox.setAlignment(Pos.CENTER_LEFT); // Align children to the left

                    setGraphic(hBox);
                }
            }
        });

        // Set ListView click handler
        ApplicationListView.setOnMouseClicked(this::handleListClick);
    }

        // Set ListView click handler

    private List<Application> loadDataFromDatabase() {
        return applicationService.getAll();
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Application selected = ApplicationListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.APPLICATION_INFO, selected);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
