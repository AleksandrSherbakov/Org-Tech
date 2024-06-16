package project.orgtech.frontController.type;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Type;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class EditTypeController implements DataReceiver<Type> {
    private Type type;

    @Override
    public void setData(Type type) {
        this.type = type;
        loadTypeData();
    }

    @Autowired
    private TypeService typeService;
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
        if (type == null) {
            sceneManager.showAlert("Ошибка", "Тип не найден");
            return;
        }

        String newName = nameField.getText();
        String newDescription = descriptionField.getText();

        // Обновляем объект Type
        type.setName(newName);
        type.setDescription(newDescription);

        // Вызываем сервис для сохранения изменений
        typeService.update(type);

        // Показываем сообщение об успешном сохранении
        sceneManager.showAlert("Успешно", "Тип сохранен");

        sceneManager.openScene(SaveButton, FxmlView.TYPE_PANEL);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.TYPE_INFO, type);
    }

    private void loadTypeData() {
        if (type != null) {
            nameField.setText(type.getName());
            descriptionField.setText(type.getDescription());
        }
    }

}
