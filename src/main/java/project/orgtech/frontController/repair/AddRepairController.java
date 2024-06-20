package project.orgtech.frontController.repair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Repair;
import project.orgtech.service.repair.RepairService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class AddRepairController {

    @Autowired
    private RepairService repairService;
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

        if(nameField==null||descriptionField==null){
            sceneManager.showAlert("Ошибка","поля должны быть заполнены");
        }
        else {
            Repair repair = new Repair();
            repair.setName(nameField.getText());
            repair.setDescription(descriptionField.getText());

            // Вызываем сервис для сохранения изменений
            repairService.add(repair);

            // Показываем сообщение об успешном сохранении
            sceneManager.showAlert("Успешно", "Ремонт создан");
            repair = null;
            sceneManager.openScene(SaveButton, FxmlView.REPAIR_PANEL);
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.REPAIR_PANEL);
    }

}
