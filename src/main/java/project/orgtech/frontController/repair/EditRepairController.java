package project.orgtech.frontController.repair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Repair;
import project.orgtech.service.repair.RepairService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class EditRepairController implements DataReceiver<Repair> {
    private Repair repair;
    @Override
    public void setData(Repair repair) {
        this.repair = repair;
        loadRepairData();
    }

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
        if (repair == null) {
            sceneManager.showAlert("Ошибка", "Ремонт не найден");
            return;
        }

        String newName = nameField.getText();
        String newDescription = descriptionField.getText();

        repair.setName(newName);
        repair.setDescription(newDescription);

        // Вызываем сервис для сохранения изменений
        repairService.update(repair);

        // Показываем сообщение об успешном сохранении
        sceneManager.showAlert("Успешно", "Ремонт сохранен");

        sceneManager.openScene(SaveButton, FxmlView.REPAIR_PANEL);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.REPAIR_INFO, repair);
    }

    private void loadRepairData() {
        if (repair != null) {
            nameField.setText(repair.getName());
            descriptionField.setText(repair.getDescription());
        }
    }

}
