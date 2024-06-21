package project.orgtech.frontController.repair;

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
import project.orgtech.models.Repair;
import project.orgtech.service.repair.RepairService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.util.List;

@Controller
public class PanelRepairController {

    @Autowired
    private SceneManager sceneManager;

    @Autowired
    private RepairService repairService;

    @FXML
    private ListView<Repair> RepairListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button CreateButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;

    private ObservableList<Repair> repairObservableList;

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
        sceneManager.openScene(CreateButton, FxmlView.REPAIR_ADD);
    }

    public void initialize() {
        // Загрузите данные из базы данных
        List<Repair> repairs = loadDataFromDatabase();

        // Преобразуйте список в ObservableList
        repairObservableList = FXCollections.observableArrayList(repairs);

        // Установите ObservableList в ListView
        RepairListView.setItems(repairObservableList);

        // Настройте отображение элементов списка
        RepairListView.setCellFactory(param -> new ListCell<Repair>() {
            @Override
            protected void updateItem(Repair repair, boolean empty) {
                super.updateItem(repair, empty);
                if (empty || repair == null || repair.getName() == null) {
                    setText(null);
                } else {
                    setText(repair.getName());
                }
            }
        });

        RepairListView.setOnMouseClicked(this::handleListClick);
    }

    private List<Repair> loadDataFromDatabase() {
        return repairService.getAll();
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Repair selectedRepair = RepairListView.getSelectionModel().getSelectedItem();
            if (selectedRepair != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.REPAIR_INFO, selectedRepair);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
