package project.orgtech.frontController.type;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Type;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class AddTypeController {

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
        if (nameField == null || descriptionField == null) {
            sceneManager.showAlert("Ошибка", "поля должны быть заполнены");
        } else {
            Type type = new Type();
            type.setName(nameField.getText());
            type.setDescription(descriptionField.getText());

            // Вызываем сервис для сохранения изменений
            typeService.add(type);

            // Показываем сообщение об успешном сохранении
            sceneManager.showAlert("Успешно", "Тип создан");
            type = null;
            sceneManager.openScene(SaveButton, FxmlView.TYPE_PANEL);
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.TYPE_PANEL);
    }

}
