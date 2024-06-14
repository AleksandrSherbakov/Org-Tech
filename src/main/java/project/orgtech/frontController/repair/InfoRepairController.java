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
public class InfoRepairController implements DataReceiver<Repair> {
    private Repair repair;

    @Autowired
    RepairService repairService;

    @Autowired
    SceneManager sceneManager;

    @FXML
    private Button BackButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private TextField nameField ;

    @FXML
    private TextField descriptionField;

    @Override
    public void setData(Repair repair) {
        this.repair = repair;
        loadRepairData();
    }

    @FXML
    private void initialize() {
    }
    @FXML
    private void handleEditButton(ActionEvent event) throws IOException {
        sceneManager.openScene(EditButton, FxmlView.REPAIR_EDIT, repair);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.REPAIR_PANEL);
    }
    @FXML
    private void handleDeleteButton(ActionEvent event) throws IOException {
        if (repair != null) {
            repairService.deleteRepair(repair.getId());
        }
        sceneManager.openScene(DeleteButton, FxmlView.REPAIR_PANEL);
    }

    private void loadRepairData() {
        if (repair != null) {
            nameField.setText(repair.getName());
            descriptionField.setText(repair.getDescription());
        }
    }
}