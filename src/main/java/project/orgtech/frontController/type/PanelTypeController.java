package project.orgtech.frontController.type;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Type;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.util.List;

@Controller
public class PanelTypeController {

    @Autowired
    private SceneManager sceneManager;

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

        // Добавьте обработчик событий для кликов на элементы списка
        TypeListView.setOnMouseClicked(this::handleListClick);
    }

    private List<Type> loadDataFromDatabase() {
        // Здесь должен быть код для загрузки данных из базы данных
        return List.of(new Type(1L, "Type1", "Description1"), new Type(2L, "Type2", "Description2"));
    }

    private void handleListClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Type selectedType = TypeListView.getSelectionModel().getSelectedItem();
            if (selectedType != null) {
                try {
                    sceneManager.openScene(ReportsButton, FxmlView.CLIENT_INFO, selectedType, InfoTypeController.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
