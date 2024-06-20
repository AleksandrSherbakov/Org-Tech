package project.orgtech.frontController.master;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Master;
import project.orgtech.service.auth.MasterService;
import project.orgtech.service.gender.GenderService;
import project.orgtech.utils.AuthManager;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class MasterEditController {

    @Autowired
    private MasterService masterService;
    @Autowired
    private GenderService genderService;

    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField loginField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField middleNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField genderField;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private void handleSaveButton(ActionEvent event) throws IOException {
        Master master = AuthManager.getMaster();
        if (master != null) {
            master.setLogin(loginField.getText());
            master.setFirstName(firstNameField.getText());
            master.setMiddleName(middleNameField.getText());
            master.setLastName(lastNameField.getText());
            // Assuming you have a way to convert the gender name back to a Gender object
            // e.g., using a GenderService or a similar mechanism
            master.setGender(genderService.getById(Long.valueOf(genderField.getId())));
            masterService.update(master);
            AuthManager.setMaster(master); // Update the AuthManager with the updated master
            sceneManager.showAlert("Успех", "Изменения сохранены успешно");
            sceneManager.openScene(saveButton, FxmlView.MASTER_INFO); // Go back to the info view
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(backButton, FxmlView.MASTER_INFO); // Go back to the info view without saving
    }

    @FXML
    public void initialize() {
        Master master = AuthManager.getMaster();
        if (master != null) {
            loginField.setText(master.getLogin());
            firstNameField.setText(master.getFirstName());
            middleNameField.setText(master.getMiddleName());
            lastNameField.setText(master.getLastName());
            genderField.setText(master.getGender().getName());
        }
    }
}