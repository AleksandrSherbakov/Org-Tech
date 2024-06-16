package project.orgtech.frontController.type;

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
import project.orgtech.models.Type;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.util.List;

@Controller
public class PanelTypeController {

    @Autowired
    private SceneManager sceneManager;

    @Autowired
    private TypeService typeService;

    @FXML
    private ListView<Type> TypeListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button CreateButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;

    private ObservableList<Type> typeObservableList;

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
        sceneManager.openScene(CreateButton, FxmlView.TYPE_ADD);
    }

    public void initialize() {
        // Загрузите данные из базы данных
        List<Type> types = loadDataFromDatabase();

        // Преобразуйте список в ObservableList
        typeObservableList = FXCollections.observableArrayList(types);

        // Установите ObservableList в ListView
        TypeListView.setItems(typeObservableList);

        // Настройте отображение элементов списка
        TypeListView.setCellFactory(param -> new ListCell<Type>() {
            @Override
            protected void updateItem(Type type, boolean empty) {
                super.updateItem(type, empty);
                if (empty || type == null || type.getName() == null) {
                    setText(null);
                } else {
                    setText(type.getName());
                }
            }
        });

        TypeListView.setOnMouseClicked(this::handleListClick);
    }

    private List<Type> loadDataFromDatabase() {
        return typeService.getAll();
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Type selectedType = TypeListView.getSelectionModel().getSelectedItem();
            if (selectedType != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.TYPE_INFO, selectedType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
